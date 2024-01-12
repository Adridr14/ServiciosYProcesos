/**
 *
 * @author IES Monte Naranco (ejer. 1)
 */
public class Contador {
    private int valor=0;

    public Contador() {

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public synchronized void decrementar(int decremento){
        if (valor<5){
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        valor-=decremento;
        System.out.println("Decremento 5 en el contador");
        notifyAll();

    }


    public synchronized void incrementar(int incremento) {

        valor+=incremento;
        System.out.println("Aumento 4 en el contador");
        if (valor>5){notifyAll();}
    }
    public void vervalor(){

    }
}
