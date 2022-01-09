package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class Splashscreen extends AppCompatActivity {

    /** Duracion de espera **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        /* Nuevo handle(identificador) para iniciar DashBoardActivity
         * y cerrar este Splashscreen despues de unos segundos. */

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                /*Crea an Intent que iniciara DashboardActivity(SplashScreen)*/
                Intent intent=new Intent ( Splashscreen.this, DashboardActivity.class);

                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
