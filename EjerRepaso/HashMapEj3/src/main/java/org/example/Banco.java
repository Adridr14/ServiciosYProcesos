package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Banco {
    private Map<String,Cuenta>cuentasBancarias= new HashMap<>();

    public void addCuenta(String nombre, int numCuenta, int balance){
        this.cuentasBancarias.put(nombre,new Cuenta(numCuenta,balance));
    }
    public Cuenta getCuenta(String nombre){
        return this.cuentasBancarias.get(nombre);
    }
    public void listarClientes(){
        Set<String> clientes=this.cuentasBancarias.keySet();
        System.out.println("--- Listar clientes---");
        for (String cliente: clientes){
            System.out.println(cliente+" ");
        }
        System.out.println("\n");
    }
    public void imprimirConKeySet(){
        Set<String> clientes=this.cuentasBancarias.keySet();
       for (String cliente:clientes){
           System.out.println(cliente+" -> "+this.cuentasBancarias.get(cliente));
       }
    }
    public void imprimirConEntrySet(){
        Set<Map.Entry<String,Cuenta>> entradas=this.cuentasBancarias.entrySet();
        for (Map.Entry<String,Cuenta> entrada:entradas){
            System.out.print(entrada.getKey()+" -> ");
            System.out.println(entrada.getValue());
        }
    }
}
