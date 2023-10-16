package org.example;

public class Despedida implements Runnable{

    private  final int ITERACIONES=10;

    @Override
    public void run() {
        Thread hilo= Thread.currentThread();
        for (int i=0; i<ITERACIONES;i++){
            System.out.println("Adiós - Hilo: "+hilo.getName() + " - número: "+i);
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // Thread.yield();
    }
}
