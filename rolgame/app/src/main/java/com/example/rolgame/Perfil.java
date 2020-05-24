package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Perfil extends AppCompatActivity {

    private static final String USERDATA_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/perfil/";

    private String username;

    private TextView nombreUsuario;
    private TextView personajeUsuario;
    private TextView combateActualUsuario;
    private TextView recordUsuario;
    private TextView oroUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        username = preferences.getString( "username", "" );
        final String url_completa = USERDATA_URL + username;

        nombreUsuario = findViewById( R.id.nombreUsuario );
        personajeUsuario = findViewById( R.id.personajeUsuario );
        combateActualUsuario = findViewById( R.id.combateActualUsuario );
        recordUsuario = findViewById( R.id.recordUsuario );
        oroUsuario = findViewById( R.id.oroUsuario );

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_completa, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            nombreUsuario.setText( username );
                            personajeUsuario.setText( response.getString( "personaje" ) );
                            combateActualUsuario.setText( String.valueOf( response.getInt( "combateActual" ) ) );
                            recordUsuario.setText( String.valueOf( response.getInt( "record" ) ) );
                            oroUsuario.setText( String.valueOf( response.getInt( "oro" ) ) );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Perfil.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
        }){};

        requestQueue.add( jsonObjectRequest );
        jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goToChangePass( android.view.View V ) {
        Intent intent = new Intent( this, ChangePassword.class );
        startActivity( intent );
    }
}
