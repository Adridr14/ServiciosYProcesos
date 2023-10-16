package org.example;

public class Movil extends Dispositivo{
    private int mpx;

    public Movil(double precio, double pulgadas, int ram, int capacidad, Modelo modelo, int mpx) {
        super(precio, pulgadas, ram, capacidad, modelo);
        this.mpx = mpx;
    }

    public int getMpx() {
        return mpx;
    }

    public void setMpx(int mpx) {
        this.mpx = mpx;
    }

    @Override
    public String toString() {
        return super.toString()+", la cámara tiene "+mpx+ " mpx";
    }
}
