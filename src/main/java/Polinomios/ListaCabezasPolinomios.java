/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polinomios;

/**
 *
 * @author win
 */
public class ListaCabezasPolinomios {

    private NodoCabezas supercabeza;
    private NodoCabezas ult;
    private NodoCabezas x;

    public ListaCabezasPolinomios(){
        this.supercabeza = new NodoCabezas();
        this.ult = ult = supercabeza;
        this.x = x = supercabeza;
    }

    public void IngresarNodo(NodoPolinomio nodo){
        NodoCabezas nuevo = new NodoCabezas (nodo,null);
        ult.setLiga(nuevo);
        ult = nuevo;    
    }
    
    public NodoPolinomio buscarPolinomio(int num){
        int posicion = num;
        x=x.getLiga();
        int contador=1;
        
        while(x.getLiga()!=null){
            if(contador==posicion){
                return x.getNodo();    
            }
            x=x.getLiga();
            contador++;
        }
        return null; 
    }

    public NodoCabezas getX() {
        return x;
    }

    public void setX(NodoCabezas x) {
        this.x = x;
    }

    public NodoCabezas getSupercabeza() {
        return supercabeza;
    }

    public void setSupercabeza(NodoCabezas supercabeza) {
        this.supercabeza = supercabeza;
    }

    public NodoCabezas getUlt() {
        return ult;
    }

    public void setUlt(NodoCabezas ult) {
        this.ult = ult;
    }
    

    
    
    
}
