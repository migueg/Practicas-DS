package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePassword extends AppCompatActivity {

    private static final String CHANGEPASS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/changepass";

    private String username;

    private EditText oldPass;
    private EditText newPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        username = preferences.getString( "username", "" );

        oldPass = findViewById( R.id.oldPass );
        newPass = findViewById( R.id.newPass );
    }

    public void goBack( android.view.View V ) {
        goToPerfil();
    }

    public void goToPerfil() {
        Intent intent = new Intent( this, Perfil.class );
        startActivity( intent );
    }

    public void changePass( android.view.View V ) {

        JSONObject js = new JSONObject();

        if( newPass.getText().length() == 0 || oldPass.getText().length() == 0 ) {
            Toast.makeText( this, "Introduce todos los datos necesarios", Toast.LENGTH_LONG ).show();
        } else {

            try {

                js.put("username", username);
                js.put("oldpass", oldPass.getText());
                js.put("newpass", newPass.getText());

                RequestQueue requestQueue = Volley.newRequestQueue(this);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, CHANGEPASS_URL, js,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    String resultado = response.getString("resultado");

                                    if (resultado.equals("OK")) {
                                        Toast.makeText(ChangePassword.this, "Contraseña cambiada con éxito.",
                                                Toast.LENGTH_LONG).show();
                                        goToPerfil();
                                    } else {
                                        Toast.makeText(ChangePassword.this, resultado, Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ChangePassword.this, error.toString(), Toast.LENGTH_LONG).show();
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

                requestQueue.add(jsonObjectRequest);
                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

}
