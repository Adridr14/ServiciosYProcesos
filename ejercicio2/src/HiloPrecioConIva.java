import java.util.Map;

public class HiloPrecioConIva extends Thread{
    //Aplica un IVA del 21%

    private Cesta cesta;
    private final double IVA=0.21;

    public HiloPrecioConIva (Cesta cesta){
        this.cesta=cesta;
    }
    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    @Override
    public void run() {
        double total=0;
        for (Map.Entry<Producto,Integer> entrada:cesta.getListaCompra().entrySet()) {
            Producto producto = entrada.getKey();
            int nUnidad = entrada.getValue();
            total+=  (producto.getPrecioUnitario()*nUnidad);
        }
        total+=(total*0.21);
        cesta.setPrecioConIva(total);
    }
}
