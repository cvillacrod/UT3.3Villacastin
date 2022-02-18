package com.politecnico.dam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.politecnico.dam.utilidades.Utilidades;
import com.squareup.picasso.Picasso;

public class GameActivity extends AppCompatActivity {

    ImageView randomImage;
    TextView numberPregunta;
    RadioGroup respuestas;
    RadioButton respuesta1;
    RadioButton respuesta2;
    TextView pregunta;
    String respuesta;
    String correcta;
    String mensajeError;
    Button boton_enviar;
    RadioButton seleccionada;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        randomImage=findViewById(R.id.imageViewAleatoria);
        Picasso.get().load("https://picsum.photos/200/300").into(randomImage);//Añade una imagen (aleatoria) de tamaño 200 x 300

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this,"bdPreguntas",null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        if(db != null) {
            db.execSQL("DELETE FROM TABLA_PREGUNTAS");//borra todas las preguntas para que no se vayan añadiendo
            db.execSQL("INSERT INTO TABLA_PREGUNTAS (id,pregunta,respuesta1,respuesta2,correcta) VALUES(1,'¿Cuál es el valor de x? 12/6=x*2', 'x=1', 'x=10', 'x=1'),(2,'¿Cuál es el valor de x? 5x+15=10x+5', 'x=4', 'x=2', 'x=2'),(3,'¿Cuál es el valor de x? 3x=9/x', 'x=3', 'x=2', 'x=3'),(4,'¿Cuál es el valor de x? 4x+2=22-x','x=4', 'x=2', 'x=4')");
            //db.execSQL(Utilidades.INTRODUCIR_PREGUNTAS);
        }

        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuestas = findViewById(R.id.respuestas);
        mensajeError = getString(R.string.toast_seleccion);
        Bundle c = getIntent().getExtras();
        if(c != null)
        {
            num = c.getInt("numero");
        }
        numberPregunta = findViewById(R.id.editTextNumberPregunta);
        numberPregunta.setText(num +"/4");
        pregunta = findViewById(R.id.textViewPregunta);
        //Busca las preguntas
        String query = "SELECT pregunta,respuesta1,respuesta2,correcta FROM TABLA_PREGUNTAS WHERE id = " + num;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor != null)
        {
            cursor.moveToFirst();
            pregunta.setText(cursor.getString(0));
            respuesta1.setText(cursor.getString(1));
            respuesta2.setText(cursor.getString(2));
            correcta = cursor.getString(3);
        }

        boton_enviar = findViewById(R.id.buttonSend);
        boton_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(respuestas.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(GameActivity.this, mensajeError,Toast.LENGTH_SHORT).show();
                }else{
                    int id = respuestas.getCheckedRadioButtonId();
                    seleccionada = findViewById(id);
                    respuesta = seleccionada.getText().toString();

                    Intent intent = new Intent(GameActivity.this,GameRespuestaActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    Bundle bundle = new Bundle();
                    bundle.putString("Respuesta",respuesta);
                    bundle.putInt("numero", num);
                    bundle.putString("Correcta",correcta);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}