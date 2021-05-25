package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        ActividadesTuristicas actividadesTuristicas;
        ImageView fotoSitio1,fotositio2;
        TextView nombre,descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asocio
        fotoSitio1=findViewById(R.id.logotipo);
        fotositio2=findViewById(R.id.logotipo2);
        nombre=findViewById(R.id.nombreLugar);
        descripcion=findViewById(R.id.descripcionLugar);

        //enlace
        actividadesTuristicas=(ActividadesTuristicas) getIntent().getSerializableExtra("datosActividadesTuristicas");

        //utilizar datos
        fotoSitio1.setImageResource(actividadesTuristicas.getFotoSitio1());
        fotositio2.setImageResource(actividadesTuristicas.getFotoSitio2());
        descripcion.setText(actividadesTuristicas.getDescripcion());
        nombre.setText(actividadesTuristicas.getNombreSitio());

    }
}