package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void goToProfile( android.view.View V ) {
        Intent intent = new Intent( this, Perfil.class );
        startActivity( intent );
    }

    public void goToCombat( android.view.View V ) {
        Intent intent = new Intent( this, Combat.class );
        startActivity( intent );
    }

    public void goToShop( android.view.View V ) {
        Intent intent = new Intent( this, Shop.class );
        startActivity( intent );
    }

    public void goToEquipment( android.view.View V ) {
        Intent intent = new Intent( this, Equipment.class );
        startActivity( intent );
    }

    public void logOut( android.view.View V ) {
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
}
