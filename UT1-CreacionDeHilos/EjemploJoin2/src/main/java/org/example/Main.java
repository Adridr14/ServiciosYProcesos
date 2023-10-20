package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Tarea(),"hilo1");
        Thread hilo2 = new Thread(new Tarea(),"hilo2");
        Thread hilo3 = new Thread(new Tarea(),"hilo3");

        hilo1.start();
        try {
            hilo1.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        hilo2.start();
        hilo3.start();
        System.out.println("Fin del hilo main");
    }
}