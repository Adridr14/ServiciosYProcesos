package org.example;

public class CuentaAhorro extends Cuenta{
    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    private double tipoInteres;
    public CuentaAhorro(String nombre,double importe,double tipoInteres){
        super(nombre,importe);
        this.tipoInteres=tipoInteres;

    }
    public double obtenerInteres(){
        return (this.getImporte()*this.tipoInteres)/100;
    }
}
