// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Thread hiloSaludo= new Saludo();
        hiloSaludo.start();
        Thread hiloDespedida= new Despedida();
        hiloDespedida.start();

        System.out.println("Fin del hilo Main");
    }
}