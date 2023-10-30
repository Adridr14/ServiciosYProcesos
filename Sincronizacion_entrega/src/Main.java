import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        File file=new File("listadoCallesMunicipio.csv");
        File fileLimpio=new File("listado-calles-limpio.csv");
        Thread hilo1=new ContadorCaracteres( file);
        hilo1.start();
        Thread hilo2=new LimpiadorFichero(file);
        hilo2.start();
        hilo2.join();
        Thread hilo3=new ContadorCaracteres(fileLimpio);
        hilo3.start();
        Thread hilo4=new FiltroCallesPorTipo(fileLimpio);
        hilo4.start();

    }
}