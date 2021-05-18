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

        listadeActividades.add(new ActividadesTuristicas("Sitios",R.drawable.sitios,R.drawable.sitios1));
        listadeActividades.add(new ActividadesTuristicas("Hoteles",R.drawable.hotel1,R.drawable.hotel2));
        listadeActividades.add(new ActividadesTuristicas("Gastronomía",R.drawable.comida1,R.drawable.comida2));
        listadeActividades.add(new ActividadesTuristicas("Economía",R.drawable.economia1,R.drawable.economia2));


    }

}