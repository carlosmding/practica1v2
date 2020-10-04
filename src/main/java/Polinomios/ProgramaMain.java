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
        int num=3;
        PolinomioListaLigada polinomios = new PolinomioListaLigada(num);
                
        
        String h = "8X^4+15X^3-25X^2-65X^1+35";
        System.out.println("Polinomio ingresado> "+h);
        polinomios.IngresarPolinomio(h,1);
        
        
        String mostrar = polinomios.mostrarPolinomio(2);
        System.out.println("Polinomio al mostrar> "+mostrar);
        
        double resultado = polinomios.evaluarPolinomio(1, 3);
        System.out.println("Evaluado el polinomio da como resultado "+resultado);
        
        String derivada = polinomios.derivarPolinomio(1);
        System.out.println("Derivada del polinomio "+derivada);
        
        
    }
}
