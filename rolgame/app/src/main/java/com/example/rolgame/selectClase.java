package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class selectClase extends AppCompatActivity {

    private static final String SELECTCLASS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/selectClass";
    private String username;
    private String eleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_clase);

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        username = preferences.getString( "username", "" );
    }

    public void selectWarrior( android.view.View V ) {
        eleccion = "Guerrero";
        sendClass();
    }

    public void selectArcher( android.view.View V ) {
        eleccion = "Arquero";
        sendClass();
    }

    public void selectMage( android.view.View V ) {
        eleccion = "Mago";
        sendClass();
    }

    private void sendClass() {

        JSONObject js = new JSONObject();

        try {

            js.put( "username", username );
            js.put( "clase", eleccion );

            RequestQueue requestQueue = Volley.newRequestQueue( this );

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, SELECTCLASS_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Intent intent = new Intent( selectClase.this, MainMenu.class );
                            startActivity( intent );
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText( selectClase.this, error.toString(), Toast.LENGTH_LONG ).show();
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

            requestQueue.add( jsonObjectRequest );
            jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
