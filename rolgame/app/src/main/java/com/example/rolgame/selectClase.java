package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class selectClase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_clase);
    }

    public void selectWarrior( android.view.View V ) {
        String eleccion = "guerrero";

        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void selectArcher( android.view.View V ) {
        String eleccion = "arquero";

        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }

    public void selectMage( android.view.View V ) {
        String eleccion = "mago";

        Intent intent = new Intent( this, MainMenu.class );
        startActivity( intent );
    }
}
