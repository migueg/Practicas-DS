package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/registroApp";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private EditText textUsername;
    private EditText textPassword;
    private Button buttonRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        textUsername = findViewById( R.id.textUsername );
        textPassword = findViewById( R.id.textPassword );

        buttonRegistro = findViewById( R.id.buttonRegistro );
        buttonRegistro.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick( View v ) {
        registro();
    }

    public void registro() {

        if( textUsername.getText().length() == 0 || textPassword.getText().length() == 0 ) {
            Toast.makeText( this, "Introduce todos los datos necesarios", Toast.LENGTH_LONG ).show();
        } else {

            final String username = textUsername.getText().toString();
            final String password = textPassword.getText().toString();

            JSONObject js = new JSONObject();

            try {
                js.put("username", username);
                js.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String resultado = response.getString("resultado");

                                if (resultado.equals("OK")) {

                                    SharedPreferences preferences = getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();

                                    editor.putString("username", username);
                                    editor.commit();

                                    goToSelectClass();
                                } else
                                    Toast.makeText(Registro.this, resultado, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Registro.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    //headers.put("Content-Type", "application/json; charset=utf-8");
                    //headers.put("Content-Type", "application/json");
                    return headers;
                }

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonObjectRequest);
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        }

    }

    public void goToSelectClass() {
        Intent intent = new Intent( this, selectClase.class );
        startActivity( intent );
    }

    public void goToLogin( android.view.View V ) {
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
}
