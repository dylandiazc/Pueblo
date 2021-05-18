package com.example.pueblo;

public class actividadesTuristicas {

    String nombreSitio;
    int fotoSitio1, fotoSitio2;

    public actividadesTuristicas(String nombreSitio, int fotoSitio1, int fotoSitio2) {
        this.nombreSitio = nombreSitio;
        this.fotoSitio1 = fotoSitio1;
        this.fotoSitio2 = fotoSitio2;
    }


    public String getNombreSitio() {
        return nombreSitio;
    }

    public void setNombreSitio(String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }

    public int getFotoSitio1() {
        return fotoSitio1;
    }

    public void setFotoSitio1(int fotoSitio1) {
        this.fotoSitio1 = fotoSitio1;
    }

    public int getFotoSitio2() {
        return fotoSitio2;
    }

    public void setFotoSitio2(int fotoSitio2) {
        this.fotoSitio2 = fotoSitio2;
    }
}
