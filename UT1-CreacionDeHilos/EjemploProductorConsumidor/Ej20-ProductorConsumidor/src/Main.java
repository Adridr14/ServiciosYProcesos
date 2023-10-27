// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        HiloConsumidor hiloC=new HiloConsumidor("Hilo Consumidor 1",buffer);
        HiloProductor hiloP=new HiloProductor("Hilo Productor",buffer);
        HiloConsumidor2 hiloC2=new HiloConsumidor2("Hilo Consumidor 2",buffer);

        hiloP.start();
        hiloC.start();
        hiloC2.start();
    }
}