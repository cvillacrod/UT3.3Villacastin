package com.politecnico.dam;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout option_maps;
    LinearLayout option_salud;
    LinearLayout option_game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        option_maps=findViewById(R.id.layoutMaps);
        //Añadimos el escuchador del boton de maps
        option_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (DashboardActivity.this, MapsActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        option_salud=findViewById(R.id.layoutMedical);
        //Añadimos el escuchador del boton de maps
        option_salud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (DashboardActivity.this, SaludActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        option_game=findViewById(R.id.layoutGames);
        //Añadimos el escuchador del boton de maps
        option_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (DashboardActivity.this, GameActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
    }
}