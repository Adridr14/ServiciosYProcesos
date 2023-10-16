package org.example;

public class CuentaCorriente extends Cuenta{
    private double minimo;
    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }


    static final double RECARGO=0.05;

    public CuentaCorriente(String nombre, double importe, double minimo){
        super(nombre,importe);
    }
    public double calcularRecargo(){
        if(this.getImporte()<minimo){
            this.setImporte(this.getImporte()*RECARGO);
            return RECARGO;}
            return 0;
    }

}
