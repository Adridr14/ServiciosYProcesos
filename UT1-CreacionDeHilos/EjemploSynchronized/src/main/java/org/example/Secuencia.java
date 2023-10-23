package org.example;

public class Secuencia {
    private int siguiente;

    public Secuencia(){
        this.siguiente=0;
    }
    public synchronized int getSiguiente(){
        siguiente=siguiente+1;
        System.out.println(Thread.currentThread().getName()+" - "+this.siguiente);
        return siguiente;
    }
}
