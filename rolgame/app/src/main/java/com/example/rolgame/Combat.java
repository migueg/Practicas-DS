package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class EstadoCombate {

    private String estado;
    private String enemigo;
    private String url;
    private int pvEnemigo;
    private int pvJugador;
    private int danioRecibido;
    private String movimientoRecibido;
    private int recompensa;

    public EstadoCombate( JSONObject js ) throws JSONException {
        this.estado = js.getString( "estado" );
        this.enemigo = js.getString( "enemigo" );
        this.url = js.getString( "url" );
        this.pvEnemigo = js.getInt( "pvEnemigo" );
        this.pvJugador = js.getInt( "pvJugador" );
        this.danioRecibido = js.getInt( "danioRecibido" );
        this.movimientoRecibido = js.getString( "movimientoRecibido" );
        this.recompensa = js.getInt( "recompensa" );
    }

    // Setters
    public void setEstado( String estado ) { this.estado = estado; }
    public void setEnemigo( String enemigo ) { this.enemigo = enemigo; }
    public void setUrl( String url ) { this.url = url; }
    public void setPvEnemigo( int pvEnemigo ) { this.pvEnemigo = pvEnemigo; }
    public void setPvJugador( int pvJugador ) { this.pvJugador = pvJugador; }
    public void setDanioRecibido( int danioRecibido ) { this.danioRecibido = danioRecibido; }
    public void setMovimientoRecibido( String movimientoRecibido ) { this.movimientoRecibido = movimientoRecibido; }
    public void setRecompensa( int recompensa ) { this.recompensa = recompensa; }

    // Getters
    public String getEstado() { return estado; }
    public String getEnemigo() { return enemigo; }
    public String getUrl() { return url; }
    public int getPvEnemigo() { return pvEnemigo; }
    public int getPvJugador() { return pvJugador; }
    public int getDanioRecibido() { return danioRecibido; }
    public String getMovimientoRecibido() { return movimientoRecibido; }
    public int getRecompensa() { return recompensa; }

    public Bitmap loadImageFromUrl() {
        InputStream is = null;
        Bitmap b = null;
        try {
            is = (InputStream) new URL(url).getContent();
            b = BitmapFactory.decodeStream( is );
            return b;
        } catch (IOException e) {
            System.out.println("ERROR EN LOADIMAGEFROMURL");
            e.printStackTrace();
        }

        return b;
    }

}

public class Combat extends AppCompatActivity {

    private static final String GETMOVS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/inicioCombate/";
    private static final String GETSTATUS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/estadoCombate/";
    private static final String ATTACK_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/turno";
    private static final String GIVEUP_URL = "http://localhost:8080/ServerREST/server/rolgame/giveup";

    private String username;
    private String url_user;

    private String[] ataques;
    private String ataqueSeleccionado;

    private Spinner spinnerAtaques;
    private Button botonTurno;

    private ImageView PlayerImage, EnemyImage;
    private TextView PlayerName, EnemyName;
    private TextView PlayerActualHP, EnemyActualHP;
    private TextView PlayerMaxHP, EnemyMaxHP;
    private TextView Turntext;

    private EstadoCombate estado;
    private int hpplayer;
    private int hpenemy;

    private void updateList() {

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, ataques );
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerAtaques.setAdapter( adaptador );

    }

    private Bitmap loadImageFromUrl( String url ) {
        System.out.println(url);
        InputStream is = null;
        Bitmap b = null;
        try {
            is = new URL(url).openStream();
            while( b == null )
                b = BitmapFactory.decodeStream( is );
            return b;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }

    private void printEstado( boolean primero ) {

        EnemyName.setText( estado.getEnemigo() );
        PlayerActualHP.setText( String.valueOf( estado.getPvJugador() ) );
        EnemyActualHP.setText( String.valueOf( estado.getPvEnemigo() ) );

        if( primero ) {
            Turntext.setText("Comienza el combate contra " + estado.getEnemigo());
            EnemyImage.setImageBitmap( estado.loadImageFromUrl() );
        } else
            Turntext.setText( estado.getEnemigo() + " ha utilizado " + estado.getMovimientoRecibido() +
                              ", produciéndote " + estado.getDanioRecibido() + " puntos de daño." );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        username = preferences.getString( "username", "" );

        Bundle extras = getIntent().getExtras();
        url_user = (String) extras.getString( "url_photo" );

        spinnerAtaques = findViewById( R.id.spinnerAtaques );
        botonTurno = findViewById( R.id.botonTurno );
        botonTurno.setEnabled( false );

        PlayerImage = findViewById( R.id.PlayerImage );
        EnemyImage = findViewById( R.id.EnemyImage );
        PlayerName = findViewById( R.id.PlayerName );
        EnemyName = findViewById( R.id.EnemyName );
        PlayerActualHP = findViewById( R.id.PlayerActualHP );
        EnemyActualHP = findViewById( R.id.EnemyActualHP );
        PlayerMaxHP = findViewById( R.id.PlayerMaxHP );
        EnemyMaxHP = findViewById( R.id.EnemyMaxHP );
        Turntext = findViewById( R.id.Turntext );

        PlayerImage.setImageBitmap( loadImageFromUrl( url_user ) );

        spinnerAtaques.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ataqueSeleccionado = parent.getItemAtPosition( position ).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        ataqueSeleccionado = parent.getItemAtPosition(0).toString();
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonArrayRequest ataquesRequest = new JsonArrayRequest(GETMOVS_URL + username,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        ataques = new String[response.length()];
                        System.out.println( "Size: " + response.length() );

                        try {
                            for( int i = 0; i < response.length(); i++ ) {
                                JSONObject obj = response.getJSONObject(i);
                                ataques[i] = obj.getString( "resultado" );
                            }
                            updateList();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Combat.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
        }){};

        JsonObjectRequest primerEstado = new JsonObjectRequest(GETSTATUS_URL + username, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            estado = new EstadoCombate(response);
                            hpplayer = estado.getPvJugador();
                            hpenemy = estado.getPvEnemigo();
                            PlayerMaxHP.setText( String.valueOf( hpplayer ) );
                            EnemyMaxHP.setText( String.valueOf( hpenemy ) );
                            PlayerName.setText( username );

                            printEstado(true);
                            botonTurno.setEnabled( true );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Combat.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
        }){};

        requestQueue.add( ataquesRequest );
        ataquesRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

        requestQueue.add( primerEstado );
        primerEstado.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

    }

    public void sendAttack( android.view.View V ) {

        JSONObject js = new JSONObject();
        botonTurno.setEnabled(false);

        try {
            js.put( "username", username );
            js.put( "movimiento", ataqueSeleccionado );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST, ATTACK_URL, js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            estado = new EstadoCombate(response);

                            if( estado.getEstado().equals( "ENCURSO" ) ) {
                                printEstado(false);
                                botonTurno.setEnabled(true);
                            } else {
                                goToResults();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( Combat.this, error.toString(), Toast.LENGTH_LONG ).show();
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

    public void giveUp( android.view.View V ) {
        goBack(V);
    }

    public void goToResults() {
        Intent intent = new Intent( this, Results.class );
        intent.putExtra( "url_photo", url_user );
        startActivity( intent );
    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }
}
