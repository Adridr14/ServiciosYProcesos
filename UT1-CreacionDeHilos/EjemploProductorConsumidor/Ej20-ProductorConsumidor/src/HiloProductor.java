public class HiloProductor extends Thread{
    private String nombre;
    private Buffer buffer;

    public HiloProductor(String nombre, Buffer buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int valor;
        for (int i=0;i<20;i++){
             valor= (int) (Math.random()*70+1);
             buffer.producir(valor);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
