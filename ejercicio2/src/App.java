public class App {

    public static void main(String[] args) {
        Cesta cesta = new Cesta();
        cesta.agregarProducto(new Producto("iPhone 15", 1200), 3);
        cesta.agregarProducto(new Producto("Zapatillas Nike AF1", 100), 10);
        cesta.agregarProducto(new Producto("Asus Zenbook 14", 1100), 5);
        cesta.agregarProducto(new Producto("Polo Aston Martin", 90), 2);
        cesta.agregarProducto(new Producto("Camiseta Real Oviedo", 80), 20);
        cesta.agregarProducto(new Producto("TV Samsung 70", 1500), 1);

        HiloFactura hiloFactura = new HiloFactura(cesta);
        HiloPrecioConIva hiloPrecioConIva = new HiloPrecioConIva(cesta);
        HiloPrecioSinIva hiloPrecioSinIva = new HiloPrecioSinIva(cesta);
        hiloPrecioSinIva.start();
        try {
            hiloPrecioSinIva.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        hiloPrecioConIva.start();
        try {
            hiloPrecioConIva.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        hiloFactura.start();
        try {
            hiloFactura.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }


    }
}
