package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GestorFiguras {
    private List <Figura>gestor;

    public GestorFiguras(List<Figura> gestor) {
        this.gestor = new ArrayList<>();
    }
    public void addFigura(Figura f){
        if(!gestor.contains(f)) {
            gestor.add(f);
        }
    }
    private void listarFiguras(List<Figura>gestor){
        for(Figura f:gestor){
            System.out.println(f.toString()+ "\n\n");
        }
    }
    public void listarFiguras(){
        this.listarFiguras(gestor);
    }
    public Figura mayorArea(){
        Figura mayor= gestor.get(0);
        int i =1;
        while(i<gestor.size()){
            Figura f=gestor.get(i);
            if(f.area()>mayor.area()){
                mayor=f;
            }
            i++;
        }
        return mayor;
    }
    public void borrarIguales(Figura f){
        Iterator<Figura> it= gestor.iterator();
        while(it.hasNext()){
            Figura fig= it.next();
            if (fig.equals(f)){
                it.remove();
            }
        }
    }
    public void ordenarPorArea(){
        List<Figura> tmp= new ArrayList<>(gestor);
        Collections.sort(tmp);
        listarFiguras(tmp);
    }
    public void ordenarPorPerimetro(){
        List<Figura> tmp= new ArrayList<>(gestor);
        Collections.sort(tmp, new ComparadorPerimetro());
        listarFiguras(tmp);
    }
}
