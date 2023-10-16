package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorNumeros  implements Runnable{
    private File fichero;

    public LectorNumeros (File fichero){
        this.fichero=fichero;
        Thread hilo= new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        try(BufferedReader lec=new BufferedReader(new FileReader(fichero))) {
            int num;
            int total=0;
            int cont=0;
            while (lec.readLine()!=null){
                num= Integer.parseInt(lec.readLine());
                System.out.println("Número leído "+num);
                total+=num;
                cont++;
            }
            System.out.println("Total Números leídos "+cont+ " Suma: "+total);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
