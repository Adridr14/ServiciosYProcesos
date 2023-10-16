package org.example;

public class Tablet extends Dispositivo{
    public Tablet(double precio, double pulgadas, int ram, int capacidad, Modelo modelo) {
        super(precio, pulgadas, ram, capacidad, modelo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
