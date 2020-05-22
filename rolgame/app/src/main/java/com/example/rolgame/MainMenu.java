package com.example.rolgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainMenu extends AppCompatActivity {

    private static final String PHOTO_URL = "http://192.168.1.40:8080/ServerREST/demo/rolgame/fotoClase/";
    private ImageView photoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        photoUser = findViewById( R.id.photoUser );

        SharedPreferences preferences = getSharedPreferences( "temp", getApplicationContext().MODE_PRIVATE );
        String login_name = preferences.getString( "username", "" );
        String url_completa = PHOTO_URL + login_name;

        RequestQueue requestQueue = Volley.newRequestQueue( this );

        StringRequest stringRequest = new StringRequest(url_completa,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        InputStream is = null;

                        try {
                            is = (InputStream) new URL(response).getContent();
                            Bitmap b = BitmapFactory.decodeStream(is);
                            photoUser.setImageBitmap(b);
                        } catch( IOException e ) {
                            System.out.println( "ERROR AL LEER IMAGEN" );
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText( MainMenu.this, error.toString(), Toast.LENGTH_LONG ).show();
                }
        }) {

        };

        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy( new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );
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
        SharedPreferences sharedPreferences = getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        startActivity( intent );
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( Intent.ACTION_MAIN );
        intent.addCategory( Intent.CATEGORY_HOME );
        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent);
    }
}
