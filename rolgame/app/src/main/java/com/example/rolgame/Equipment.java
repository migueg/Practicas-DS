package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

import java.lang.reflect.Array;
import java.util.ArrayList;

class Inventario {

    private String tipo;
    private String nombre;
    private int bonusAtaque;
    private int bonusVida;
    private int durabilidad;

    public Inventario(JSONObject recibido) {

        try {
            this.tipo = recibido.getString( "tipo");

            switch(tipo) {
                case "arma":
                    this.nombre = recibido.getString( "nombreArma" );
                    this.bonusAtaque = recibido.getInt( "dañoArma" );
                    this.bonusVida = 0;
                    this.durabilidad = recibido.getInt( "vidaArma" );
                    break;
                case "armadura":
                    this.nombre = recibido.getString( "nombreArmadura" );
                    this.bonusAtaque = 0;
                    this.bonusVida = recibido.getInt( "plusVida" );
                    this.durabilidad = recibido.getInt( "vidaArmadura" );
                    break;
                case "accesorio":
                    this.nombre = recibido.getString( "nombreAccesorio" );
                    this.bonusAtaque = recibido.getInt( "ataqueAccesorio" );
                    this.bonusVida = recibido.getInt( "vidaAccesorio" );
                    this.durabilidad = 100;
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // Getters
    public String getTipo() { return tipo; }
    public String getNombre() { return nombre; }
    public int getBonusAtaque() { return bonusAtaque; }
    public int getBonusVida() { return bonusVida; }
    public int getDurabilidad() { return durabilidad; }

}

public class Equipment extends AppCompatActivity {

    private static final String EQUIP_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/equiparConf";
    private static final String INVEN_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/inventario/";
    private String login_name;

    private ArrayList<Inventario> armas = new ArrayList<>();
    private ArrayList<Inventario> armaduras = new ArrayList<>();
    private ArrayList<Inventario> accesorios = new ArrayList<>();

    private String[] armasNombres;
    private String[] armadurasNombres;
    private String[] accesoriosNombres;

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

        spinnerArmas = findViewById( R.id.spinnerArmas );
        spinnerArmaduras = findViewById( R.id.spinnerArmaduras );
        spinnerAccesorios = findViewById( R.id.spinnerAccesorios );

        etiqHP = findViewById( R.id.etiqHP );
        etiqATK = findViewById( R.id.etiqATK );

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        login_name = preferences.getString( "username", "" );
        String url_completa = INVEN_URL + login_name;

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_completa,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            armas.add( new Inventario( response.getJSONObject(0) ) );
                            armaduras.add( new Inventario( response.getJSONObject(1) ) );
                            accesorios.add( new Inventario( response.getJSONObject(2) ) );

                            for( int i = 3; i < response.length(); i++ ) {
                                Inventario nuevo = new Inventario( response.getJSONObject(i) );
                                switch( nuevo.getTipo() ) {
                                    case "arma":
                                        armas.add(nuevo);
                                        break;
                                    case "armadura":
                                        armaduras.add(nuevo);
                                        break;
                                    case "accesorio":
                                        accesorios.add(nuevo);
                                        break;
                                }
                            }

                            armasNombres = new String[armas.size()];
                            for( int i = 0; i < armas.size(); i++ )
                                armasNombres[i] = armas.get(i).getNombre();

                            armadurasNombres = new String[armaduras.size()];
                            for( int i = 0; i < armaduras.size(); i++ )
                                armadurasNombres[i] = armaduras.get(i).getNombre();

                            accesoriosNombres = new String[accesorios.size()];
                            for( int i = 0; i < accesorios.size(); i++ )
                                accesoriosNombres[i] = accesorios.get(i).getNombre();

                            updateLists();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( Equipment.this, error.toString(), Toast.LENGTH_LONG ).show();
                }
        }) {

        };

        requestQueue.add( jsonArrayRequest );
        jsonArrayRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );


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

    private void updateLists() {

        ArrayAdapter<String> adaptadorArmas = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, armasNombres );
        ArrayAdapter<String> adaptadorArmaduras = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, armadurasNombres );
        ArrayAdapter<String> adaptadorAccesorios = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, accesoriosNombres );

        adaptadorArmas.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        adaptadorArmaduras.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        adaptadorAccesorios.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinnerArmas.setAdapter( adaptadorArmas );
        spinnerArmaduras.setAdapter( adaptadorArmaduras );
        spinnerAccesorios.setAdapter( adaptadorAccesorios );

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void changeWeapon( android.view.View V ) {

        JSONObject js = new JSONObject();

        try {

            js.put( "username", login_name );
            js.put( "tipo", "arma" );
            js.put( "nombre", armaSeleccionada );

            RequestQueue requestQueue = Volley.newRequestQueue( this );

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, EQUIP_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            reLoad();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText( Equipment.this, error.toString(), Toast.LENGTH_LONG ).show();
                        }
            }) {

            };

            requestQueue.add( jsonObjectRequest );
            jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );


        }catch( JSONException e ) {
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
        }

    }

    public void changeArmor( android.view.View V ) {

        JSONObject js = new JSONObject();

        try {

            js.put( "username", login_name );
            js.put( "tipo", "armadura" );
            js.put( "nombre", armaduraSeleccionada );

            RequestQueue requestQueue = Volley.newRequestQueue( this );

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, EQUIP_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            reLoad();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( Equipment.this, error.toString(), Toast.LENGTH_LONG ).show();
                }
            }) {

            };

            requestQueue.add( jsonObjectRequest );
            jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );


        }catch( JSONException e ) {
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
        }

    }

    public void changeAcc( android.view.View V ) {

        JSONObject js = new JSONObject();

        try {

            js.put( "username", login_name );
            js.put( "tipo", "accesorio" );
            js.put( "nombre", accesorioSeleccionado );

            RequestQueue requestQueue = Volley.newRequestQueue( this );

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, EQUIP_URL, js,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            reLoad();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( Equipment.this, error.toString(), Toast.LENGTH_LONG ).show();
                }
            }) {

            };

            requestQueue.add( jsonObjectRequest );
            jsonObjectRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );


        }catch( JSONException e ) {
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
        }

    }

    private void reLoad() {
        Toast.makeText( Equipment.this, "¡Equipamiento cambiado!", Toast.LENGTH_LONG ).show();
        Intent intent = new Intent( this, Equipment.class );
        startActivity( intent );
    }
}


