package org.example;

import java.io.*;
import java.util.Scanner;

public class ContadorPalabras implements Runnable{
    private File file;

    public ContadorPalabras (File file){
       this.file=file;
       Thread hilo= new Thread(this);
       hilo.start();
    }

    @Override
    public void run() {
        try(Scanner lec= new Scanner(file)){
            String linea;
            int nPalabras=0;
            while (lec.hasNextLine()){
                linea=lec.nextLine();
                String[] pLinea=linea.split(" ");
                 nPalabras +=pLinea.length;
            }
            System.out.println(file.getName() +" palabras: "+nPalabras);
        }catch(FileNotFoundException e){
         e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
