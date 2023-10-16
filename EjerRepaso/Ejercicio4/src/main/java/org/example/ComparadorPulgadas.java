package org.example;

import java.util.Comparator;

public class ComparadorPulgadas implements Comparator<Movil> {
    @Override
    public int compare(Movil o1, Movil o2) {
        return (int)(Math.signum(o1.getPulgadas()-o2.getPulgadas()));
    }
}
