package org.example;

public class ContadorAscendente implements Runnable{
    private int contador;

    public ContadorAscendente(int contador) {

        this.contador = contador;
        Thread hiloAsc= new Thread(this);
        hiloAsc.start();
    }

    @Override
    public void run() {
        Thread hilo=Thread.currentThread();
        for (int i=0;i<contador;i++){
            System.out.println("Hilo: "+hilo.getName()+" Contador:"+i);
            Thread.yield();
        }
        System.out.println("Fin del hilo "+ hilo.getName());
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
