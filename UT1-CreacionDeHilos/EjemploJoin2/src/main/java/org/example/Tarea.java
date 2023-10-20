package org.example;

public class Tarea implements Runnable{
    @Override
    public void run() {
        Thread t= Thread.currentThread();
        System.out.println("Hilo se inicia: "+t.getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hilo finaliza: "+t.getName());
    }
}
