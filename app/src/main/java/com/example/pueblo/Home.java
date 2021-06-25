package com.example.pueblo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<ActividadesTuristicas> listadeActividades=new ArrayList<>();
    RecyclerView listadoGrafico;

    FirebaseFirestore baseDatos=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listadoGrafico=findViewById(R.id.listado);
        listadoGrafico.setHasFixedSize(true);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();

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

        baseDatos.collection("actividades")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre=document.get("nombre").toString();
                                String descripcion=document.get("descripcion").toString();
                                String foto1=document.get("foto1").toString();
                                String foto2=document.get("foto2").toString();

                                listadeActividades.add(new ActividadesTuristicas(nombre,descripcion,foto1,foto2));
                            }
                            ListaAdaptador adaptador=new ListaAdaptador(listadeActividades);
                            listadoGrafico.setAdapter(adaptador);

                        }else{

                            Toast.makeText(Home.this, "Error en consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }

}