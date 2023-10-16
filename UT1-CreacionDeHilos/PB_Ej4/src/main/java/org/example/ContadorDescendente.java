package org.example;

public class ContadorDescendente implements Runnable{

    private int contador;

    public ContadorDescendente(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        Thread hilo=Thread.currentThread();
        for (int i=this.contador;i>0;i--){
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
