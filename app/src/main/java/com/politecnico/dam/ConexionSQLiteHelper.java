package com.politecnico.dam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.politecnico.dam.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //final String CREAR_TABLA_PREGUNTAS="CREATE TABLE preguntas (id INTEGER, pregunta String, respuesta1 String, respuesta2 String, correcta String)";

    //final String INTRODUCIR_PREGUNTAS="INSERT INTO preguntas (id, pregunta, respuesta1, respuesta2, correcta) VALUES (1, '¿Cuál es el valor de x? 12/6=x*2', 'x=1', 'x=10', 'x=1'),(2, '¿Cuál es el valor de x? 5x+15=10x+5', 'x=4', 'x=2', 'x=2'),  (3, '¿Cuál es el valor de x? 3x=9/x', 'x=3', 'x=2', 'x=3'),(4, '¿Cuál es el valor de x? 4x+2=22-x','x=4', 'x=2', 'x=4')";

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         db.execSQL(Utilidades.CREAR_TABLA_PREGUNTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilidades.TABLA_PREGUNTAS");
        onCreate(db);
    }
}
