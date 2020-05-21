package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class Objeto implements Serializable {

    private String nombre;
    private String tipo;
    private int bonusAtaque;
    private int bonusVida;
    private int coste;
    private String descripcion;
    private int dineroTotal;

    public Objeto() {}
    public Objeto(JSONObject js) {
        try {
            this.nombre = js.getString("nombre");
            this.tipo = js.getString("tipo");
            this.bonusAtaque = js.getInt("bonusAtaque");
            this.bonusVida = js.getInt( "bonusVida" );
            this.coste = js.getInt( "coste" );
            this.descripcion = js.getString( "descripcion" );
            this.dineroTotal = js.getInt( "dineroTotal" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Getters para mostrar
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getBonusAtaque() { return bonusAtaque; }
    public int getBonusVida() { return bonusVida; }
    public int getCoste() { return coste; }
    public String getDescripcion() { return descripcion; }
    public int getDineroTotal() { return dineroTotal; }

    // Setters
    public void setNombre( String nombre ) { this.nombre = nombre; }
    public void setTipo( String tipo ) { this.tipo = tipo; }
    public void setBonusAtaque( int bonusAtaque ) { this.bonusAtaque = bonusAtaque; }
    public void setBonusVida( int bonusVida ) { this.bonusVida = bonusVida; }
    public void setCoste( int coste ) { this.coste = coste; }
    public void setDescripcion( String descripcion ) { this.descripcion = descripcion; }
    public void setDineroTotal( int dineroTotal ) { this.dineroTotal = dineroTotal; }

}

public class Shop extends AppCompatActivity {

    private static final String SHOP_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/shop/";

    private TextView nameShop0, nameShop1, nameShop2;
    private TextView typeShop0, typeShop1, typeShop2;
    private ImageView imageShop0, imageShop1, imageShop2;
    private Objeto obj0, obj1, obj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // Obtenemos los objetos que necesitamos de la vista
        nameShop0 = findViewById( R.id.nameShop0 );
        nameShop1 = findViewById( R.id.nameShop1 );
        nameShop2 = findViewById( R.id.nameShop2 );
        typeShop0 = findViewById( R.id.typeShop0 );
        typeShop1 = findViewById( R.id.typeShop1 );
        typeShop2 = findViewById( R.id.typeShop2 );
        imageShop0 = findViewById( R.id.imageShop0 );
        imageShop1 = findViewById( R.id.imageShop1 );
        imageShop2 = findViewById( R.id.imageShop2 );

        // Para que la sesión se mantenga iniciada
        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        String login_name = preferences.getString( "username", "" );
        String url_completa = SHOP_URL + login_name;

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest( url_completa,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse( JSONArray jsonArray ) {

                        try {
                            obj0 = new Objeto( jsonArray.getJSONObject(0) );
                            obj1 = new Objeto( jsonArray.getJSONObject(1) );
                            obj2 = new Objeto( jsonArray.getJSONObject(2) );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Modificamos la vista en función de los objetos
                        nameShop0.setText( obj0.getNombre() );
                        typeShop0.setText( obj0.getTipo() );

                        nameShop1.setText( obj1.getNombre() );
                        typeShop1.setText( obj1.getTipo() );

                        nameShop2.setText( obj2.getNombre() );
                        typeShop2.setText( obj2.getTipo() );

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Shop.this, error.toString(), Toast.LENGTH_LONG ).show();
                    }
                })  {
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

        requestQueue.add(jsonArrayRequest);
        jsonArrayRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goObj0( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra("sampleObject", obj0 );
        startActivity( intent );
    }

    public void goObj1( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra("sampleObject", obj1 );
        startActivity( intent );
    }

    public void goObj2( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra("sampleObject", obj2 );
        startActivity( intent );
    }
}
