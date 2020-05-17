package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Combat extends AppCompatActivity {

    public static final String ATTACK_URL = "http://localhost:8080/ServerREST/server/rolgame/attack";
    public static final String GIVEUP_URL = "http://localhost:8080/ServerREST/server/rolgame/giveup";

    private String[] ataques;
    private String ataqueSeleccionado;

    private Spinner spinnerAtaques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        ataques = new String[] {"Ataque Basico","Ataque Poderoso"};
        spinnerAtaques = findViewById( R.id.spinnerAtaques );

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, ataques );

        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerAtaques.setAdapter( adaptador );

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
