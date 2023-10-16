package org.example;

import java.awt.*;

public class Circulo extends Figura{
    private double radio;

    public Circulo(int x, int y, Color color, double radio) {
        super(x, y, color);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {

        return Math.PI*this.radio*this.radio;
    }

    @Override
    public double perimetro() {
        return Math.PI*2*this.radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }
}
