public class ContadorDescendente extends Thread{

    private int contador;

    public ContadorDescendente(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i=this.contador;i>0;i--){
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
