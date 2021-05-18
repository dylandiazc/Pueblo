package com.example.pueblo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<ActividadesTuristicas> listadeDatos;

    public ListaAdaptador(ArrayList<ActividadesTuristicas> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);

        return new viewHolder(vistaDelItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        
        holder.actualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nombreSitio;
        ImageView fotoSitio1, fotoSitio2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreSitio=itemView.findViewById(R.id.sitioNombre);
            fotoSitio1=itemView.findViewById(R.id.sitioFoto1);
            fotoSitio2=itemView.findViewById(R.id.sitioFoto2);
        }

        public void actualizarDatos(final ActividadesTuristicas actividadesTuristicas) {
            nombreSitio.setText(actividadesTuristicas.getNombreSitio());
            fotoSitio1.setImageResource(actividadesTuristicas.getFotoSitio1());
            fotoSitio2.setImageResource(actividadesTuristicas.getFotoSitio2());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("datosActividadesTuristicas",actividadesTuristicas);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
