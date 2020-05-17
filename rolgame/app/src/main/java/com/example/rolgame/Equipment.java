package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Equipment extends AppCompatActivity {

    public static final String CHANGE_URL = "http://localhost:8080/ServerRest/server/rolgame/changeEQ";

    private String[] armas;
    private String[] armaduras;
    private String[] accesorios;

    private String armaSeleccionada;
    private String armaduraSeleccionada;
    private String accesorioSeleccionado;

    private Spinner spinnerArmas;
    private Spinner spinnerArmaduras;
    private Spinner spinnerAccesorios;

    private TextView etiqHP;
    private TextView etiqATK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        armas = new String[]{"Nada","Espada de madera"};
        armaduras = new String[]{"Nada","Ropa de tela"};
        accesorios = new String[]{"Nada"};

        spinnerArmas = findViewById( R.id.spinnerArmas );
        spinnerArmaduras = findViewById( R.id.spinnerArmaduras );
        spinnerAccesorios = findViewById( R.id.spinnerAccesorios );

        etiqHP = findViewById( R.id.etiqHP );
        etiqATK = findViewById( R.id.etiqATK );

        ArrayAdapter<String> adaptadorArmas = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, armas );
        ArrayAdapter<String> adaptadorArmaduras = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, armaduras );
        ArrayAdapter<String> adaptadorAccesorios = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, accesorios );

        adaptadorArmas.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        adaptadorArmaduras.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        adaptadorAccesorios.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinnerArmas.setAdapter( adaptadorArmas );
        spinnerArmaduras.setAdapter( adaptadorArmaduras );
        spinnerAccesorios.setAdapter( adaptadorAccesorios );

        spinnerArmas.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        armaSeleccionada = parent.getItemAtPosition( position ).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        armaSeleccionada = parent.getItemAtPosition(0).toString();
                    }
                }
        );

        spinnerArmaduras.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        armaduraSeleccionada = parent.getItemAtPosition( position ).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        armaduraSeleccionada = parent.getItemAtPosition(0).toString();
                    }
                }
        );

        spinnerAccesorios.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        accesorioSeleccionado = parent.getItemAtPosition( position ).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        accesorioSeleccionado = parent.getItemAtPosition(0).toString();
                    }
                }
        );
    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, Registro.class );
        startActivity( intent );
    }

    public void changeEquipment( android.view.View V ) {
        Toast.makeText( this, "¡Equipamiento cambiado!", Toast.LENGTH_LONG ).show();
    }
}
