import java.io.IOException;

/**
 *
 * @author IES Monte Naranco (ejer. 1)
 */
public class AppMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Contador contador=new Contador();
        Thread hiloI=new Thread(new HiloIncremento(contador));
        Thread hiloD=new Thread(new HiloDecremento(contador));
        hiloI.start();
        hiloD.start();
        while (hiloD.isAlive() || hiloI.isAlive()){}
        System.out.println("Valor final del contador: "+contador.getValor());
        System.out.println("Fin del main y del ejercicio 1");
    }
    
}
