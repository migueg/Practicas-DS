package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //public static final String LOGIN_URL = "http://localhost:8080/ServerREST/server/rolgame/login";
    private static final String LOGIN_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/loginjs";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private EditText textUsername;
    private EditText textPassword;
    private Button buttonLogin;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUsername = findViewById( R.id.textUsername );
        textPassword = findViewById( R.id.textPassword );

        buttonLogin = findViewById( R.id.buttonLogin );
        buttonLogin.setOnClickListener((View.OnClickListener) this);

        // Para que la sesión se mantenga iniciada
        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        String login_name = preferences.getString( "username", "" );

        if( login_name != "" ) {
            Intent i = new Intent( this, MainMenu.class );

            startActivity(i);
            finish();
        }
    }


    @Override
    public void onClick( View v ) {
        login();
    }
    /*
    @Override
    public void onClick( View v ) {
        goToMainMenu();
    }*/

    public void login() {

        if (textUsername.getText().length() == 0 || textPassword.getText().length() == 0) {
            Toast.makeText(this, "Introduce todos los datos necesarios", Toast.LENGTH_LONG).show();
        } else {

            username = textUsername.getText().toString();
            password = textPassword.getText().toString();


            JSONObject js = new JSONObject();

            try {
                js.put("username", username);
                js.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        /*
            Map<String, String> postParam= new HashMap<String, String>();
            postParam.put("username", username );
            postParam.put("password", password );*/

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, LOGIN_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            String resultado = "";

                            try {
                                resultado = response.get("resultado").toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            if (resultado.equals("Los datos introducidos no son correctos."))
                                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_LONG).show();
                            else if (resultado.equals(""))
                                Toast.makeText(MainActivity.this, "Error al leer el json", Toast.LENGTH_LONG).show();
                            else {
                                SharedPreferences preferences = getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString("username", username);
                                editor.commit();

                                goToMainMenu();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
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

                @Override
                public Map<String, String> getParams() {
                    HashMap<String, String> params = new HashMap<>();
                    params.put(KEY_USERNAME, username);
                    params.put(KEY_PASSWORD, password);
                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonObjectRequest);
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        }

    }

    public void goToMainMenu() {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goToRegistro( android.view.View V ) {
        Intent intent = new Intent( this, Registro.class );
        startActivity( intent );
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( Intent.ACTION_MAIN );
        intent.addCategory( Intent.CATEGORY_HOME );
        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent);
    }

}
