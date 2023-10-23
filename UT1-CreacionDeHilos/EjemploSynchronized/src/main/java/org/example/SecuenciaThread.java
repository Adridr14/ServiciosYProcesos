package org.example;

public class SecuenciaThread extends Thread{
    private final int TIEMPO=300;
    private Secuencia secuencia;

    public SecuenciaThread(Secuencia secuencia){
        this.secuencia=secuencia;
    }
    @Override
    public void run(){
        for (int i=0;i<10;i++){
            secuencia.getSiguiente();


            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
