package org.example;

public class TareaContarCapicuas implements Runnable{
  private int [] vec;
  private int comienza;
  private int acaba;
  private  int nPrimos=0;

    @Override
    public void run() {
        Thread hilo=Thread.currentThread();
        for (int i =comienza;comienza<=acaba && i< vec.length;i++)
        {
           if((comprobarCapicua(vec[i])))
           {
               this.nPrimos++;
           }
        }
        System.out.println(hilo.getName()+ " "+nPrimos);
    }

    private boolean comprobarCapicua(int n) {
        boolean es=false;
        String numero= String.valueOf(n);
        if (n<10){

            es=true;
        } else if (n<100) {
            if (numero.charAt(0)==numero.charAt(1)){

                es=true;
            }
        } else if (n<1000) {
            if (numero.charAt(0)==numero.charAt(2)){

                es=true;
            }
        }
        //for (int i= 0; i<n.length /2; i++)
        // if (numero.charAt(i) != numero.charAt(longitud -1 -i)
        //return false; }
        return es;
    }

    public TareaContarCapicuas (int []vec,int comienza, int acaba){
        this.vec=vec;
        this.comienza=comienza;
        this.acaba=acaba;
    }

    public int[] getVec() {
        return vec;
    }

    public void setVec(int[] vec) {
        this.vec = vec;
    }

    public int getComienza() {
        return comienza;
    }

    public void setComienza(int comienza) {
        this.comienza = comienza;
    }

    public int getAcaba() {
        return acaba;
    }

    public void setAcaba(int acaba) {
        this.acaba = acaba;
    }

    public int getnPrimos() {
        return nPrimos;
    }

    public void setnPrimos(int nPrimos) {
        this.nPrimos = nPrimos;
    }
}
