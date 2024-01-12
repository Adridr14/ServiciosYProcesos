/**
 *
 * @author IES Monte Naranco (ejer. 1)
 */
public class HiloDecremento implements Runnable {

    private final int DECREMENTO = 5;
    private final int NDECREMENTOS=10;
    private final int PAUSA=250;
  private final Contador contador;
    public HiloDecremento(Contador contador){
        this.contador=contador;



    }

    @Override
    public void run() {
        Thread th=Thread.currentThread();

        for (int i =0 ; i<NDECREMENTOS;i++){
            contador.decrementar(DECREMENTO);
            try {
                Thread.sleep(PAUSA);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
