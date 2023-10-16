package org.example;

public class Portatil extends Dispositivo{
    private boolean dvd;
    private String tarjeta;

    public Portatil(double precio, double pulgadas, int ram, int capacidad, Modelo modelo, boolean dvd, String tarjeta) {
        super(precio, pulgadas, ram, capacidad, modelo);
        this.dvd = dvd;
        this.tarjeta=tarjeta;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    @Override
    public String toString() {
        return super.toString()+", reproductor DVD : "+dvd+" , la tarjeta gráfica es: "+tarjeta;
    }
}
