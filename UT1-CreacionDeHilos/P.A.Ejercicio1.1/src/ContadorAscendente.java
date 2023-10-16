public class ContadorAscendente extends Thread{
    private int contador;

    public ContadorAscendente(int contador) {
        this.contador = contador;

    }


    @Override
    public void run() {
        for (int i=0;i<contador;i++){
            System.out.println("Hilo: "+this.getName()+" Contador:"+i);
            Thread.yield();
        }
        System.out.println("Fin del hilo "+ this.getName());
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
