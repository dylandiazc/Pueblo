package com.example.pueblo;

import java.io.Serializable;

public class ActividadesTuristicas implements Serializable {
    String nombreSitio, descripcion, fotoSitio1, fotoSitio2;


    public ActividadesTuristicas(String nombreSitio, String descripcion, String fotoSitio1, String fotoSitio2) {
        this.nombreSitio = nombreSitio;
        this.descripcion = descripcion;
        this.fotoSitio1 = fotoSitio1;
        this.fotoSitio2 = fotoSitio2;
    }

    public String getNombreSitio() {
        return nombreSitio;
    }

    public void setNombreSitio(String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoSitio1() {
        return fotoSitio1;
    }

    public void setFotoSitio1(String fotoSitio1) {
        this.fotoSitio1 = fotoSitio1;
    }

    public String getFotoSitio2() {
        return fotoSitio2;
    }

    public void setFotoSitio2(String fotoSitio2) {
        this.fotoSitio2 = fotoSitio2;
    }
}