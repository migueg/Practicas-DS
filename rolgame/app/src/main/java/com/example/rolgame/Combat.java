package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class Combat extends AppCompatActivity {

    private static final String GETMOVS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/inicioCombate/";
    private static final String GETSTATUS_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/estadoCombate/";
    private static final String ATTACK_URL = "http://localhost:8080/ServerREST/server/rolgame/attack";
    private static final String GIVEUP_URL = "http://localhost:8080/ServerREST/server/rolgame/giveup";

    private String username;

    private String[] ataques;
    private String ataqueSeleccionado;

    private Spinner spinnerAtaques;
    private Button botonTurno;

    private ImageView PlayerImage, EnemyImage;
    private TextView PlayerName, EnemyName;
    private TextView PlayerActualHP, EnemyActualHP;
    private TextView PlayerMaxHP, EnemyMaxHP;
    private TextView Turntext;

    private int hp

    private void updateList() {

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, ataques );
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerAtaques.setAdapter( adaptador );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        username = preferences.getString( "username", "" );

        ataques = new String[] {"Ataque Basico","Ataque Poderoso"};
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

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){};

        JsonArrayRequest primerEstado = new JsonArrayRequest(GETSTATUS_URL + username,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){};
    }

    public void sendAttack( android.view.View V ) {

        Toast.makeText( this, "Seleccionado: " + ataqueSeleccionado, Toast.LENGTH_LONG ).show();

    }

    public void giveUp( android.view.View V ) {

        goBack(V);

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }
}
