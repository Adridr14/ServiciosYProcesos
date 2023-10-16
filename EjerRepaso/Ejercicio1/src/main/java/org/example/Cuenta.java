package org.example;

public class Cuenta {
    private double importe;
    private String nombre;

    public Cuenta(String nombre,double importe) {
        this.importe = importe;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    public void ingresar(double ingreso){
        if(ingreso>0){
            this.importe +=ingreso;
        }
    }
    public void reintegrar(double reintegro){
        if(reintegro>0){
            this.importe-=reintegro;
        }
    }
    public String toString(){
        StringBuilder sb=new StringBuilder("Informacion de la cuenta");
                sb.append("Nombre: "+nombre+"/n");
                sb.append("Importe: "+importe+"/n");
                return sb.toString();
    }
}
