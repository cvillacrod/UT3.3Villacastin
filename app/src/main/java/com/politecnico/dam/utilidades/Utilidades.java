package com.politecnico.dam.utilidades;

public class Utilidades {

    public static final String TABLA_PREGUNTAS="preguntas";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_PREGUNTA="pregunta";
    public static final String CAMPO_RESPUESTA1="respuesta1";
    public static final String CAMPO_RESPUESTA2="respuesta2";
    public static final String CAMPO_CORRECTA="correcta";


    public static final String CREAR_TABLA_PREGUNTAS="CREATE TABLE TABLA_PREGUNTAS("+CAMPO_ID+" INTEGER, "+CAMPO_PREGUNTA+" String, "+CAMPO_RESPUESTA1+" String, "+CAMPO_RESPUESTA2+" String, "+CAMPO_CORRECTA+" String)";

    //public static final String INTRODUCIR_PREGUNTAS="INSERT INTO TABLA_PREGUNTAS ("+CAMPO_ID+", "+CAMPO_PREGUNTA+", "+CAMPO_RESPUESTA1+", "+CAMPO_RESPUESTA2+", "+CAMPO_CORRECTA+") VALUES(1,'¿Cuál es el valor de x? 12/6=x*2', 'x=1', 'x=10', 'x=1'),(2,'¿Cuál es el valor de x? 5x+15=10x+5', 'x=4', 'x=2', 'x=2'),(3,'¿Cuál es el valor de x? 3x=9/x', 'x=3', 'x=2', 'x=3'),(4,'¿Cuál es el valor de x? 4x+2=22-x','x=4', 'x=2', 'x=4') ";

}

