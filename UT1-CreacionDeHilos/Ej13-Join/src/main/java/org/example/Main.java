package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hiloPares = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i =2; i<21;i++){

                    System.out.println(Thread.currentThread().getName()+" -  Par: "+i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread hiloPrimos = new Thread(new Runnable() {
            @Override
            public void run() {
                int[] primos= {2,3,5,7};
                for (int i=0; i<primos.length;i++){
                    System.out.println(Thread.currentThread().getName()+" - Primo: "+primos[i]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        hiloPares.start();
        hiloPares.join();
        hiloPrimos.start();
        hiloPrimos.join();
        System.out.println("Aqui acaba el hilo main()");
    }
}