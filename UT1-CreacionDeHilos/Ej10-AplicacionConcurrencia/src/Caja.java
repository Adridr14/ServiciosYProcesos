public class Caja {
    private String nombre;

    public void procesarCompra(Consumidor consumidor, long tiempo){
        System.out.println("Cajera: "+this.nombre+"recibe compra del cliente: "+consumidor.getNombre()+" - Tiempo: "+tiempo+"seg");
        for (int i=0;i<consumidor.getCarro().length;i++){
            System.out.println("Cajera: "+this.nombre+);
        }
    }

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
