package org.example;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Dispositivo> {
    @Override
    public int compare(Dispositivo o1, Dispositivo o2) {
        return (int)(Math.signum(o1.getPrecio()-o2.getPrecio()));
    }
}
