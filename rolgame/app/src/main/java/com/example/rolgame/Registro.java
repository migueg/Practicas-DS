package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registro( android.view.View V ) {
        Intent intent = new Intent( this, selectClase.class );
        startActivity( intent );
    }

    public void goToLogin( android.view.View V ) {
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
}
