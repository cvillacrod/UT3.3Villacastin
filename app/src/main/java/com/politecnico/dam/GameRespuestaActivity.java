package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameRespuestaActivity extends AppCompatActivity {

    Button Salir;
    String respuestaCorrecta;
    String respuesta;
    TextView solucion;
    Button botonSiguiente;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_respuesta);

        solucion = findViewById(R.id.textViewCorrecta);
        botonSiguiente = findViewById((R.id.buttonSiguiente));

        Bundle b = getIntent().getExtras();
        if(b != null)
        {
            respuesta = b.getString("Respuesta");
            numero = b.getInt("numero");
            respuestaCorrecta = b.getString("Correcta");
        }
        if((respuesta.equals(respuestaCorrecta)&& numero==4)){
            solucion.setText(R.string.enhorabuena);
            botonSiguiente.setText(R.string.reiniciar);
            botonSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GameRespuestaActivity.this,GameActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    numero=1;
                    Bundle bundle = new Bundle();
                    bundle.putInt("numero",numero);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(respuesta.equals(respuestaCorrecta)) {
            solucion.setText(R.string.correcto);
            botonSiguiente.setText(R.string.siguiente);
            botonSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GameRespuestaActivity.this,GameActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    numero++;
                    Bundle bundle = new Bundle();
                    bundle.putInt("numero",numero);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            });
        }else{
            solucion.setText(R.string.error);
            botonSiguiente.setText(R.string.repetir);
            botonSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GameRespuestaActivity.this,GameActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    Bundle bundle = new Bundle();
                    bundle.putInt("numero",numero);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            });
        }
        Salir = findViewById(R.id.buttonSalir);
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}