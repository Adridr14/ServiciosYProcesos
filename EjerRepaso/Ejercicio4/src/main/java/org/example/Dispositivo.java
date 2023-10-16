package org.example;

public class Dispositivo {
    private double precio;
    private double pulgadas;
    private int ram;
    private int capacidad;
    private Modelo modelo;

    public Dispositivo(double precio,double pulgadas, int ram, int capacidad,Modelo modelo) {
        this.precio=precio;
        this.pulgadas=pulgadas;
        this.ram=ram;
        this.capacidad=capacidad;
        this.modelo = modelo;
    }
    public Dispositivo(){
        this(0,0,0,0,null);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "El precio es" + precio +
                ",las pulgadas son" + pulgadas +
                ",la ram es" + ram +
                " GB,la capacidad es" + capacidad +
                " GB,el Sisteama operativo es" + modelo +
                '}';
    }
}
