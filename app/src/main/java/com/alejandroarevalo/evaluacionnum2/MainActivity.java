package com.alejandroarevalo.evaluacionnum2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //metodo boton para agregar registro
    public void AgregarRegistroIntent(View view) {
        Intent siguiente = new Intent(this, AgregarRegistros.class);
        startActivity(siguiente);
    }

    //metodo boton para activity del GPS
    public void LocalizacionGoogleMapsGps(View view) {
        Intent GoogleMaps = new Intent(this, MapsActivity.class);
        startActivity(GoogleMaps);
    }

    //metodo boton ver sensores
    public void SensorView (View view) {
        Intent sensor = new Intent(this, SensoresAct.class);
        startActivity(sensor);
    }






}