package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Hucha hucha=new Hucha();
       Thread hilos[]=new Thread[100];
       for (int i=0;i<hilos.length;i++){
           hilos[i]=new HiloHucha(hucha);
           hilos[i].start();

       }
       for (int i=0;i<hilos.length;i++){
           hilos[i].join();
       }
        System.out.println("El total de la hucha es: "+hucha.getTotal());
    }
}