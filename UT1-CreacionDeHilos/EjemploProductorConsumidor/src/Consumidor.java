public class Consumidor extends Thread{

    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        int valor=0;
        for (int i = 1; i <= 10; i++) {
           valor=contenedor.consumir();
        }
    }
}


