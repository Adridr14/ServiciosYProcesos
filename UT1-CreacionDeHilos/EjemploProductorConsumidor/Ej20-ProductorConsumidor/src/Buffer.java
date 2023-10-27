import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Integer> contenido;
    private final int TAM=10;

    public Buffer(){
        this.contenido=new ArrayList<>(TAM);
    }

    public synchronized void producir(int valor) {
        while (contenido.size()==TAM) {
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        contenido.add(valor);
        System.out.println(Thread.currentThread().getName()+" Produciendo: "+valor);
        notifyAll();
    }

    public synchronized void consumir(int indice) {
        while (contenido.isEmpty()) {
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
            System.out.println(" Consumiendo: "+contenido.get(indice));
            contenido.remove(indice);
            notifyAll();


    }
}
