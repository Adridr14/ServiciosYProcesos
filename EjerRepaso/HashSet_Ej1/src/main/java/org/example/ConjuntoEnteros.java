package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConjuntoEnteros {
    private Set<Integer> entero;
    private int tam;

    public ConjuntoEnteros(int tam) {
        this.tam = tam;
        entero=new HashSet<>();

        for (int i=0; i<tam;i++){
            entero.add((int)(Math.random()*100));
        }
    }
    private boolean verPar(int n){
        if(n%2==0){
            return true;
        }return false;
    }

    public Set<Integer> getPares(){
        Set<Integer> pares=new HashSet<>();
        Iterator<Integer> it= entero.iterator(); {
        while (it.hasNext()){
            Integer n= it.next();
            if(verPar(n)==true){
                pares.add(n);
            }
        }


        }
        return pares;
    }
    
    public void addNumero(int n){
        entero.add(n);
    }
    public void printConjunto(){
        for (Integer n:
             entero) {
            System.out.println(n);
        }
    }
    public void borrarPares(){
        Iterator<Integer> it= entero.iterator();
        while (it.hasNext()){
            int n=it.next();
            if (verPar(n)==true){
                it.remove();
            }
        }
    }
    public Set<Integer> getEntero() {
        return entero;
    }

    public void setEntero(Set<Integer> entero) {
        this.entero = entero;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }


}
