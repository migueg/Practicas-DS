package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

class Objeto {

    private String nombre;
    private String tipo;
    private int ID;

    public Objeto( String nombre, String tipo, int ID ) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ID = ID;
    }

    // Getters para mostrar
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getID() { return ID; }

}

public class Shop extends AppCompatActivity {

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

        // Creamos los objetos a tratar
        obj0 = new Objeto("Varita de olivo", "Arma", 0 );
        obj1 = new Objeto( "Cota de malla", "Armadura", 1 );
        obj2 = new Objeto( "Anillo naranja", "Accesorio", 2 );

        // Modificamos la vista en función de los objetos
        nameShop0.setText( obj0.getNombre() );
        typeShop0.setText( obj0.getTipo() );

        nameShop1.setText( obj1.getNombre() );
        typeShop1.setText( obj1.getTipo() );

        nameShop2.setText( obj2.getNombre() );
        typeShop2.setText( obj2.getTipo() );

    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void goObj0( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra( "objID", obj0.getID() );
        startActivity( intent );
    }

    public void goObj1( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra( "objID", obj1.getID() );
        startActivity( intent );
    }

    public void goObj2( android.view.View V ) {
        Intent intent = new Intent( this, BuyObject.class );
        intent.putExtra( "objID", obj2.getID() );
        startActivity( intent );
    }
}
