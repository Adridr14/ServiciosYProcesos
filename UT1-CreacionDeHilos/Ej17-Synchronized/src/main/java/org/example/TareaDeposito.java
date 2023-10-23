package org.example;

public class TareaDeposito extends Thread {
    private final int TIEMPO=1000;
    private final int CANT=100;
    private  CuentaBancaria cuentaBancaria;

    public  TareaDeposito (CuentaBancaria cuentaBancaria){
        this.cuentaBancaria=cuentaBancaria;
    }
    @Override
    public void run(){
        for (int i =0;i<10;i++){
            cuentaBancaria.depositar(CANT);
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
