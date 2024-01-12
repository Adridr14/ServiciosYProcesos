import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HiloFactura extends Thread{
    private final String ruta="factura.txt";
    private Cesta cesta;

    public HiloFactura(Cesta cesta){
        this.cesta=cesta;

    }

    @Override
    public void run() {
        try (BufferedWriter escritor=new BufferedWriter(new FileWriter(ruta))){
            for (Map.Entry<Producto,Integer> entrada:cesta.getListaCompra().entrySet()) {
                Producto producto= entrada.getKey();
                int nUnidad=entrada.getValue();
                escritor.write(producto.getNombre()+"-"+producto.getPrecioUnitario()+"-"+nUnidad);
                escritor.newLine();
            }
            escritor.write("Precio sin IVA = "+cesta.getPrecioSinIva());
            escritor.newLine();
            escritor.write("Precio con IVA= "+cesta.getPrecioConIva());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
