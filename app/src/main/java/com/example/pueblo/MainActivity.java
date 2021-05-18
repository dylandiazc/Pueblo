package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        ActividadesTuristicas actividadesTuristicas;
        ImageView fotoSitio;
        TextView nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asocio
        fotoSitio=findViewById(R.id.logotipo);
        nombre=findViewById(R.id.nombreLugar);

        //enlace
        actividadesTuristicas=(ActividadesTuristicas) getIntent().getSerializableExtra("datosActividadesTuristicas");

        //utilizar datos
        fotoSitio.setImageResource(actividadesTuristicas.getFotoSitio1());
        nombre.setText(actividadesTuristicas.getNombreSitio());

    }
}