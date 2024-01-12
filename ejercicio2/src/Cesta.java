import java.util.HashMap;
import java.util.Map;

public class Cesta {

    private double precioSinIva;
    private double precioConIva;

    private Map<Producto, Integer> listaCompra;

    public Cesta() {
        listaCompra = new HashMap<>();
    }


    public void agregarProducto(Producto producto, int cantidad) {
        listaCompra.put(producto, cantidad);
    }


    public Map<Producto, Integer> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(Map<Producto, Integer> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public double getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(double precioConIva) {
        this.precioConIva = precioConIva;
    }
}
