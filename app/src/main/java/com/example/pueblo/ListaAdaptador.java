package com.example.pueblo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<actividadesTuristicas> listadeDatos;

    public ListaAdaptador(ArrayList<actividadesTuristicas> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,null,false);
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

        public void actualizarDatos(actividadesTuristicas actividadesTuristicas) {
            nombreSitio.setText(actividadesTuristicas.getNombreSitio());
            fotoSitio2.setImageResource(actividadesTuristicas.getFotoSitio1());
            fotoSitio2.setImageResource(actividadesTuristicas.getFotoSitio2());
        }
    }
}
