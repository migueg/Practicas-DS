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

    public static final String LOGIN_URL = "http://localhost:8080/ServerREST/server/rolgame/login";
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

    public void login() {

        username = textUsername.getText().toString().trim();
        password = textPassword.getText().toString().trim();

        JSONObject js = new JSONObject();

        try {
            js.put( "username", username );
            js.put( "password", password );
        } catch( JSONException e ) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST, LOGIN_URL, js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse( JSONObject response ) {
                        if( response.toString().trim().equals("Los datos introducidos no son correctos."))
                            Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                        else {
                            SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
                            SharedPreferences.Editor editor = preferences.edit();

                            editor.putString( "username", username );
                            editor.commit();

                            goToMainMenu();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse( VolleyError error ) {
                        Toast.makeText( MainActivity.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String,String>();
                headers.put( "Content-Type", "application/json; charset=utf-8" );
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    public void goToMainMenu() {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goToRegistro( android.view.View V ) {
        Intent intent = new Intent( this, Registro.class );
        startActivity( intent );
    }

}
