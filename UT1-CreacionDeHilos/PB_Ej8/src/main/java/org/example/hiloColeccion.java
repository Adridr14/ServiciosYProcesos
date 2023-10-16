package org.example;

import java.util.Set;
import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class hiloColeccion implements Runnable{
    int nPersonas;
    Set<Persona> colec;
    public  hiloColeccion(int nPersonas){
        Thread hilo=new Thread();
        this.nPersonas=nPersonas;
        colec=new TreeSet<>();
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
            try {
                for (int i=0;i<nPersonas;i++){
                    Persona p=new Persona(generarEdad(),generarDNI());
                    colec.add(p);
                    System.out.println("Persona añadida a la coleccion: "+p.toString());
                Thread.sleep(500);}
            } catch (InterruptedException e) {
               e.getMessage();
            }
        }
    }

