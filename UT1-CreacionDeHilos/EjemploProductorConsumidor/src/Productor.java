public class Productor extends Thread {
    private Contenedor contenedor;

    public Productor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            contenedor.producir(i);
        }
    }
}
