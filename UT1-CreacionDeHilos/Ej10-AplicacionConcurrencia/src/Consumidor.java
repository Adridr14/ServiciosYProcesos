import java.util.Arrays;

public class Consumidor {
    private String nombre;
    private int[] carro;

    public Consumidor(String nombre) {
        this.nombre = nombre;
        this.carro = new int[]{1,2,3,4,5};
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarro() {
        return carro;
    }

    public void setCarro(int[] carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Consumidor{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", carro=").append(Arrays.toString(carro));
        sb.append('}');
        return sb.toString();
    }
}
