package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EjemploHiloAnonima {
    public static void main(String[] args) {

         Thread segundoHilo =new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Propiedades del segundo hilo");
                System.out.println("Nombre : " +Thread.currentThread().getName());
                System.out.println("Prioridad : "+Thread.currentThread().getPriority());
                System.out.println("ID : "+Thread.currentThread().getId());
                System.out.println("Estado : "+Thread.currentThread().getState());
                System.out.println("¿Está vivo? : "+Thread.currentThread().isAlive());
                System.out.println("¿Demonio (en 2º plano)? : "+Thread.currentThread().isDaemon());
            }
        });
         segundoHilo.start();
    }
}