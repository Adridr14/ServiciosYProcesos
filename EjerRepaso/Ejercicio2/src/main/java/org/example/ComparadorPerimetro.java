package org.example;

import java.util.Comparator;

public class ComparadorPerimetro implements Comparator<Figura> {
    @Override
    public int compare(Figura o1, Figura o2) {
        return (int)(Math.signum(o1.perimetro()-o2.perimetro()));
    }
}
