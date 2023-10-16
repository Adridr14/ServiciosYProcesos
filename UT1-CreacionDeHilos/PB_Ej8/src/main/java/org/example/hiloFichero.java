package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class hiloFichero implements Runnable{
    int nPersonas;
    File file;
    public  hiloFichero(int nPersonas){
        Thread hilo=new Thread();
        this.nPersonas=nPersonas;
        file= new File("personas.txt");

        hilo.start();
    }

    public String generarDNI (){
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<9;i++) {
            int n = (int) (Math.random() * 9) + 1;
            sb.append(n);
        }
        char letra=  (char) (Math.random()*(91-65)+65);
        sb.append(letra);
        return sb.toString();
    }
    public int generarEdad(){
        int edad= (int)(Math.random()*(100-10)+10);
        return  edad;
    }

    @Override
    public void run() {
            try (BufferedWriter esc=new BufferedWriter(new FileWriter(file))){
                for (int i=0;i<nPersonas;i++) {
                    Persona p = new Persona(generarEdad(), generarDNI());
                    esc.write("Persona :"+" Edad: "+p.getEdad()+" DNI: "+p.getDni());
                    System.out.println("Persona añadida al fichero :"+p.toString());
                    Thread.sleep(500);
                }
            } catch (InterruptedException | IOException e) {
                e.getMessage();
            }

    }
}
