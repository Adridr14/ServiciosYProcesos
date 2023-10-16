package org.example;

import java.awt.*;
import java.util.Objects;

public abstract class Figura implements Comparable<Figura>{
    private Point centro;
    private Color color;

    public Figura(int x,int y, Color color) {
    this.centro=new Point(x,y);
    this.color=color;
    }

    public Point getCentro() {
        return centro;
    }

    public void setCentro(Point centro) {
        this.centro = centro;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public abstract double area();
    public abstract double perimetro();

    @Override
    public String toString() {
        return "Figura{" +
                "centro=" + centro +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;
        return Objects.equals(centro, figura.centro) && Objects.equals(color, figura.color) && this.area()==((Figura)o).area();
    }

    @Override
    public int hashCode() {
        return Objects.hash(centro, color);
    }

    @Override
    public int compareTo(Figura o) {
        if(this.area()<o.area()){
            return -1;
        }
        if (this.area()<o.area()){
            return 1;
        }return 0;
    }
}
