import java.util.Map;

public class HiloPrecioSinIva extends Thread{

    Cesta cesta;

    public HiloPrecioSinIva(Cesta cesta) {
        this.cesta = cesta;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    @Override
    public void run() {
        double total = 0;
        for (Map.Entry<Producto, Integer> entrada : cesta.getListaCompra().entrySet()) {
            Producto producto = entrada.getKey();
            int nUnidad = entrada.getValue();
            total += (producto.getPrecioUnitario() * nUnidad);
        }
        cesta.setPrecioSinIva(total);
    }
}
