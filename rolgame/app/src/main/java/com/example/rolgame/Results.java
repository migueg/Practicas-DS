package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Results extends AppCompatActivity {

    private static final String RESULT_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/resultado/";
    String url_user;

    private TextView viewResultado;
    private TextView viewOroActual;
    private TextView viewOroAcumulado;
    private TextView viewRecord;
    private TextView viewRoto;
    private TextView labelOro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        url_user = (String) extras.getString( "url_photo" );

        viewResultado = findViewById( R.id.viewResultado );
        viewOroActual = findViewById( R.id.viewOroActual );
        viewOroAcumulado = findViewById( R.id.viewOroAcumulado );
        viewRecord = findViewById( R.id.viewRecord );
        viewRoto = findViewById( R.id.viewRoto );
        labelOro = findViewById( R.id.labelOro );

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        String login_name = preferences.getString( "username", "" );
        String url_completa = RESULT_URL + login_name;

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url_completa, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String resultado = null;
                        try {
                            resultado = response.getString( "resultado" );

                            if( resultado.equals( "GANADO" ) ) {
                                viewResultado.setText( "¡¡¡VICTORIA!!!" );
                                viewOroActual.setText( response.getString( "recompensa" ) );
                                viewOroAcumulado.setText( response.getString( "oro" ) );

                                int combateActual = response.getInt( "combateActual" );
                                int record = response.getInt( "record" );

                                if( record > combateActual )
                                    viewRecord.setText("");
                                else
                                    viewRecord.setText("¡Nuevo record alcanzado: " + record + "!" );

                                if( response.getBoolean( "algoRoto" ) )
                                    viewRoto.setText( "Algo que estaba equipado se ha roto..." );
                                else
                                    viewRoto.setText("");

                            } else {
                                viewResultado.setText( "DERROTA..." );
                                viewOroActual.setText( response.getString( "recompensa" ) );
                                viewOroAcumulado.setText( response.getString( "oro" ) );
                                viewRecord.setText("");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Results.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
        }){};

        requestQueue.add(jsonObjectRequest);
        jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

    }

    public void goToMainMenu( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goToNextCombat( android.view.View V ) {
        Intent intent = new Intent( this, Combat.class );
        intent.putExtra( "url_photo", url_user );
        startActivity( intent );
    }
}
