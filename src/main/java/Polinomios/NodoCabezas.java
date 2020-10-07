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
public class NodoCabezas {
    private NodoPolinomio nodo;
    private NodoCabezas liga;
    private int Num;

    public NodoCabezas() {
    }

    public NodoCabezas(NodoPolinomio nodo, NodoCabezas liga, int Num) {
        this.nodo = nodo;
        this.liga = liga;
        this.Num = Num;
    }

    public NodoPolinomio getNodo() {
        return nodo;
    }

    public void setNodo(NodoPolinomio nodo) {
        this.nodo = nodo;
    }

    public NodoCabezas getLiga() {
        return liga;
    }

    public void setLiga(NodoCabezas liga) {
        this.liga = liga;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }
    


    
    
    



    
    
    
}
