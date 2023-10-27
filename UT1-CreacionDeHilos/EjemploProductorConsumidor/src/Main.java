// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Contenedor contenedor=new Contenedor();
        Productor productor=new Productor(contenedor);
        Consumidor consumidor=new Consumidor(contenedor);

        productor.start();
        consumidor.start();
    }
}