package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Registro extends AppCompatActivity implements View.OnClickListener {

    public static final String REGISTER_URL = "http://localhost:8080/ServerREST/server/rolgame/registro";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private EditText textUsername;
    private EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        textUsername = findViewById( R.id.textUsername );
        textPassword = findViewById( R.id.textPassword );
    }

    @Override
    public void onClick( View v ) {
        registro();
    }

    public void registro() {

        final String username = textUsername.getText().toString().trim();
        final String password = textPassword.getText().toString().trim();

        JSONObject js = new JSONObject();

        try {
            js.put( "username", username );
            js.put( "password", password );
        } catch( JSONException e ) {
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.toString().trim().equals("OK")) {
                            Toast.makeText(Registro.this, "¡Registro completado!", Toast.LENGTH_LONG).show();
                            goToSelectClass();
                        } else
                            Toast.makeText(Registro.this, response.toString(), Toast.LENGTH_LONG).show();
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
                Map<String,String> headers = new HashMap<String,String>();
                headers.put( "Content-Type", "application/json; charset=utf-8" );
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

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
