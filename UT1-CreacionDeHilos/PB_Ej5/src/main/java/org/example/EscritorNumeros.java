package org.example;

import java.io.*;

public class EscritorNumeros implements Runnable{
    private File fichero;

    public EscritorNumeros (){

        Thread hilo= new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        try(BufferedWriter esc=new BufferedWriter(new FileWriter("aleatorios.txt",true))) {
            int num;
            int total=10;

            for (int i=0;i<total;i++){
                num= (int) (Math.random()*100);
                esc.write(num);
                System.out.println("Número escrito "+num);
                total+=num;

            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
