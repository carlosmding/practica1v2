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
public class ProgramaMain {
    
    public static void main(String[] args) {
        
        //cuantos polinomios desea ingresar
        
        //lista ligada de nodoscabeza primer nodo
        ListaCabezasPolinomios listacab = new ListaCabezasPolinomios();
        
        String Poli;
        Poli = "25X^2-65X^1+35";
        PolinomioListaLigada polinomios = new PolinomioListaLigada();
        
        NodoPolinomio nodo = polinomios.IngresarPolinomio(Poli);
        listacab.IngresarNodo(nodo);
        
        int posicion=1;
        NodoPolinomio nodo2 = listacab.buscarPolinomio(posicion);
        
        String mostrar = polinomios.mostrarPolinomio(nodo2);
        System.out.println("Polinomio al mostrar> "+mostrar);
        
        /*        
        // Ingresar Polinomios
        Poli = "25X^2-65X^1+35";
        polinomios.IngresarPolinomio(Poli,1);
        
        Poli= "5X^2-65X^1+35";
        polinomios.IngresarPolinomio(Poli,2);
        
        */
        //Mostrar polinomios
        /*
        
        String mostrar2 = polinomios.mostrarPolinomio(2);
        System.out.println("Polinomio al mostrar> "+mostrar2);
        
        /*
        //Metodo evaluar polinomio
        
        if(polinomios.getContarPolinomios()==0){
            System.out.println("No hay polinomios para evaluar");
        }else{
            double resultado = polinomios.evaluarPolinomio(2, 3);
            System.out.println("Evaluado el polinomio da como resultado "+resultado);
        }
        
        //Metodo derivar polinomio
        if(polinomios.getContarPolinomios()==0){
            System.out.println("No hay polinomios para derivar");
        }else{
            String derivada = polinomios.derivarPolinomio(1);
            System.out.println("Derivada del polinomio "+derivada);
        }
 
       //Metodo mostrar todos
       int n=0;
       while(n<num){
            String todos = polinomios.mostrarPolinomio(n+1);
            System.out.println((n+1)+". >>> "+todos);
            n++;
       }
       */
       /* 
        polinomios.multipolicarPolinomios(1, 2, 3);
        
        String mostrar3 = polinomios.mostrarPolinomio(3);
        System.out.println("Polinomio al mostrar> "+mostrar3);
   
        */
    }
}
