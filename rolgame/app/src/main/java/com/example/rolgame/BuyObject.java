package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class BuyObject extends AppCompatActivity {

    private Objeto obj;

    private static final String BUY_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/buy";

    private TextView nameObj;
    private TextView descripcionObj;
    private TextView goldObj;
    private TextView goldPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_object);

        Intent intent = getIntent();
        obj = (Objeto) intent.getSerializableExtra( "sampleObject" );

        nameObj = findViewById( R.id.nameObj );
        descripcionObj = findViewById( R.id.descripcionObj );
        goldObj = findViewById( R.id.goldObj );
        goldPlayer = findViewById( R.id.goldPlayer );

        nameObj.setText( obj.getNombre() );
        descripcionObj.setText( obj.getDescripcion() );
        goldObj.setText( String.valueOf( obj.getCoste() ) );
        goldPlayer.setText( String.valueOf( obj.getDineroTotal() ) );

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, Shop.class );
        startActivity( intent );
    }

    public void finalizarCompra() {
        Intent intent = new Intent( this, Shop.class );
        startActivity( intent );
    }

    public void buyObj( android.view.View V ) {

        JSONObject js = new JSONObject();

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        String username = preferences.getString( "username", "" );

        try {
            js.put( "username", username );
            js.put( "nombre", obj.getNombre() );
            js.put( "tipo", obj.getTipo() );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BUY_URL, js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String resultado = "";

                        try {
                            resultado = response.getString( "resultado" );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if( resultado.equals( "Compra realizada." ) ) {
                            Toast.makeText(BuyObject.this, resultado, Toast.LENGTH_LONG ).show();
                            finalizarCompra();
                        } else if( resultado.equals( "Oro insuficiente." ) ) {
                            Toast.makeText( BuyObject.this, resultado, Toast.LENGTH_LONG ).show();
                        } else {
                            Toast.makeText( BuyObject.this, "Error al leer el json", Toast.LENGTH_LONG ).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( BuyObject.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
                }) {

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                HashMap<String,String> headers = new HashMap<>();
                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

        };

        requestQueue.add( jsonObjectRequest );
        jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy( 50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

    }
}
