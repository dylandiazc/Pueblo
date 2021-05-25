package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<ActividadesTuristicas> listadeActividades=new ArrayList<>();
    RecyclerView listadoGrafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listadoGrafico=findViewById(R.id.listado);
        listadoGrafico.setHasFixedSize(true);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();
        ListaAdaptador adaptador=new ListaAdaptador(listadeActividades);
        listadoGrafico.setAdapter(adaptador);
    }

    private void crearLista(){

        listadeActividades.add(new ActividadesTuristicas("Sitios",getString(R.string.descripcion1),R.drawable.sitios,R.drawable.sitios1));
        listadeActividades.add(new ActividadesTuristicas("Hoteles",getString(R.string.descripcion2),R.drawable.hotel1,R.drawable.hotel2));
        listadeActividades.add(new ActividadesTuristicas("Gastronomía",getString(R.string.descripcion3),R.drawable.comida1,R.drawable.comida2));
        listadeActividades.add(new ActividadesTuristicas("Economía",getString(R.string.descripcion4),R.drawable.economia1,R.drawable.economia2));


    }

}