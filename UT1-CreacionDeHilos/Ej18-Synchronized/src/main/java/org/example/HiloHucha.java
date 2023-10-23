package org.example;

public class HiloHucha extends Thread{
    private final int TIEMPO=30;
    private Hucha hucha;
    private final int CANT=2;

    public HiloHucha (Hucha hucha){
        this.hucha=hucha;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            hucha.add(CANT);
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
