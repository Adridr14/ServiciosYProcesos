public class HiloConsumidor2 extends Thread{
    private String nombre;
    private Buffer buffer;

    public HiloConsumidor2(String nombre, Buffer buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            buffer.consumir(i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
