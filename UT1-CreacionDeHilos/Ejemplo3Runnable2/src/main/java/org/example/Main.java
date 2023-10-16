package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Thread hiloSaludo= new Thread(new Saludo());

        //hiloSaludo.start();
        Saludo hiloSaludo= new Saludo();
        Thread hiloDespedida= new Thread(new Runnable() {
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
            });
        hiloDespedida.start();



        System.out.println("Fin del hilo Main");
    }
}