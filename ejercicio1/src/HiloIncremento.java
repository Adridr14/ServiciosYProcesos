/**
 *
 * @author IES Monte Naranco (ejer. 1)
 */
public class HiloIncremento  implements Runnable{

    private final int INCREMENTO = 4;
    private final int NINCREMENTOS=15;
    private final Contador contador;
    private final int PAUSA=500;
    public HiloIncremento(Contador contador){
        this.contador=contador;


    }

    @Override
    public void run() {
        Thread th=Thread.currentThread();
        for (int i =0 ; i<NINCREMENTOS;i++){
            contador.incrementar(INCREMENTO);
            try {
                Thread.sleep(PAUSA);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


    





