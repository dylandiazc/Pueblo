package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Locale;

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

    public void cambiarIdioma(String lenguaje){

        Locale idioma=new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono=getResources().getConfiguration();
        configuracionTelefono.locale=idioma;

        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id= item.getItemId();

        switch (id){

            case(R.id.opcion1):
                Intent intent1=new Intent(Home.this,Acercade.class);
                startActivity(intent1);
                break;

            case(R.id.opcion2):
                cambiarIdioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;

            case(R.id.opcion3):
                cambiarIdioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);

    }




    private void crearLista(){

        listadeActividades.add(new ActividadesTuristicas("Sitios",getString(R.string.descripcion1),R.drawable.sitios,R.drawable.sitios1));
        listadeActividades.add(new ActividadesTuristicas("Hoteles",getString(R.string.descripcion2),R.drawable.hotel1,R.drawable.hotel2));
        listadeActividades.add(new ActividadesTuristicas("Gastronomía",getString(R.string.descripcion3),R.drawable.comida1,R.drawable.comida2));
        listadeActividades.add(new ActividadesTuristicas("Economía",getString(R.string.descripcion4),R.drawable.economia1,R.drawable.economia2));


    }

}