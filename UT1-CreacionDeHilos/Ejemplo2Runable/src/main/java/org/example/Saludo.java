package org.example;

public class Saludo implements Runnable {

    private  final int ITERACIONES=10;

    @Override
    public void run() {
        Thread hilo= Thread.currentThread();
        for (int i=0; i<ITERACIONES;i++){
            System.out.println("Hola - Hilo: "+hilo.getName() + " - número: "+i);

            //Thread.yield(); Método que para la ejecución del hilo
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
