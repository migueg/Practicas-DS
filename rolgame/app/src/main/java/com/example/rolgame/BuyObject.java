package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BuyObject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_object);
    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, Shop.class );
        startActivity( intent );
    }

    public void buyObj( android.view.View V ) {
        Intent intent = new Intent( this, Shop.class );
        startActivity( intent );
    }
}
