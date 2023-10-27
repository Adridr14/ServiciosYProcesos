public class Contenedor {
    private int contenido;
    private boolean disponible;

    public synchronized void producir(int valor) {
        while (disponible) {
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        contenido=valor;
        System.out.println("Produciendo: "+this.contenido);
        disponible=true;
        notifyAll();
    }

    public synchronized int consumir(){
        while (!disponible){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        disponible=false;
        System.out.println("Consumiendo: "+this.contenido);
        notifyAll();
        return contenido;
    }
}
