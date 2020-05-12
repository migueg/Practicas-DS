package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }

    public void goBack( android.view.View V ) {
        Intent intent = new Intent( this, Perfil.class );
        startActivity( intent );
    }

    public void changePass( android.view.View V ) {
        Intent intent = new Intent( this, Perfil.class );
        startActivity( intent );
    }

}
