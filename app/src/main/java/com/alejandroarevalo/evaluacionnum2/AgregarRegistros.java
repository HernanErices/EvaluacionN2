package com.alejandroarevalo.evaluacionnum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarRegistros extends AppCompatActivity {

    private EditText et_nombre, et_valor, et_fecha, et_hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_registros);

        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_valor = (EditText) findViewById(R.id.txt_valor);
        et_fecha = (EditText) findViewById(R.id.txt_fecha);
        et_hora = (EditText) findViewById(R.id.txt_hora);

    }

    //Metodo para regresar al Main Activity
    public void Regresar(View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }

    //Metodo Registrar datos
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String valor = et_valor.getText().toString();
        String fecha = et_fecha.getText().toString();
        String hora = et_hora.getText().toString();

        if(!nombre.isEmpty() && !valor.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("valor", valor);
            registro.put("fecha", fecha);
            registro.put("hora", hora);

            BaseDeDatos.insert("datos", null, registro);
            BaseDeDatos.close();
            et_nombre.setText("");
            et_valor.setText("");
            et_fecha.setText("");
            et_hora.setText("");

            Toast.makeText(this, "registro exitoso", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Faltan datos por rellenar", Toast.LENGTH_LONG).show();
        }

    }





}