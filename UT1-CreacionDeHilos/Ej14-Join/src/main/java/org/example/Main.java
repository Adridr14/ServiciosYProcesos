package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int vec[]=new  int[1000];
        for (int i=0;i<vec.length;i++){
            vec[i]= (int) ((Math.random()*999)+1);
        }
        Thread hilo1= new Thread(new TareaContarCapicuas(vec,0,333));
        Thread hilo2= new Thread(new TareaContarCapicuas(vec,334,666));
        Thread hilo3= new Thread(new TareaContarCapicuas(vec,667,999));
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}