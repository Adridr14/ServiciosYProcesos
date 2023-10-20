package org.example;

public class TareaContarCapicuas implements Runnable{
  private int [] vec;
  private int comienza;
  private int acaba;
  private  int nPrimos=0;

    @Override
    public void run() {
        for (int i =comienza;comienza<=acaba;i++)
        {
           if((comprobarCapicua(vec[i])))
           {
               this.nPrimos++;
           }
        }
    }

    private boolean comprobarCapicua(int n) {
        boolean es=false;

        if (Integer.reverse(n)==n){
            es=true;
        }
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
