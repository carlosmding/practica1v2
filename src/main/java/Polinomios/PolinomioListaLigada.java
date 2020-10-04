/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package Polinomios;
import java.lang.Math;

/**
 * Clase que representa un polinomio en lista ligada simple con nodo cabeza
 *
 * @author alejandroescobar
 */
public class PolinomioListaLigada {

    private NodoPolinomio [] cabezas;
    private int contarPolinomios;

    /**
     * Constructor para un polinomio sin terminos
     */
    PolinomioListaLigada(int n) {
        cabezas = new NodoPolinomio[n];
        
        for (int i = 0; i < cabezas.length; i++) {
            cabezas[i]= new NodoPolinomio();
        }
    }

    /**
     * Obtener el nodo cabeza de la lista
     *
     * @return
     */
    public NodoPolinomio getCabeza(int n) {
        return cabezas[n];
    }

    //@Override
/*    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        NodoPolinomio p = cabeza.getLiga();
        while (!finRecorrido(p)) {
            Termino ti = p.getTermino();
            double j = ti.getC();
            int i = ti.getE();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
            if (j >= 0) {
                polinomio.append("+");
            }
            polinomio.append(j).append("X^").append(i).append(" ");
            p = p.getLiga();
        }
        return polinomio.toString();
    }

    public int getGrado() throws Exception {
        NodoPolinomio primero = cabeza.getLiga();
        if (primero == null) {
            return 0;
        }
        return primero.getTermino().getE();
    }
*/
    
    public void IngresarPolinomio (String hilera, int n){
        
        NodoPolinomio recorrido = new NodoPolinomio();
        recorrido = cabezas[n-1];
        NodoPolinomio ultimo = recorrido;
        
        StringBuilder numero = new StringBuilder();
        
        for (int i = 0; i < hilera.length(); i++) {
            char c = hilera.charAt(i);
 
            if(c >= '0' &&  c<= '9' ){
                numero.append(c);    
            }
            switch (c) {
                case 'X':
                case 'x':
                    Termino termino = new Termino();
                    double coeficiente = Double.parseDouble(numero.toString());
                    termino.setC(coeficiente);
                    recorrido = new NodoPolinomio (termino);
                    ultimo.setLiga(recorrido);
                    ultimo =recorrido;
                    
                    
                    //System.out.println("coeficiente "+recorrido.getTermino().getC());
                    break;
                
                case '^':
                    numero.setLength(0);
                    break;
                    
                case '+':
                    int exp = Integer.parseInt(numero.toString());
                    recorrido.getTermino().setE(exp);
                    numero.setLength(0);
                    break;
                    
                case '-':
                    int expneg = Integer.parseInt(numero.toString());
                    recorrido.getTermino().setE(expneg);
                    numero.setLength(0);
                    String negativo = "-";
                    numero.append(negativo);
                    break;       
            }
            
        }
        Termino terminofinal = new Termino();
        double coeficiente = Double.parseDouble(numero.toString());
        terminofinal.setC(coeficiente);
        terminofinal.setE(0);
        recorrido = new NodoPolinomio (terminofinal);
        ultimo.setLiga(recorrido);
        ultimo =recorrido;
        
        contarPolinomios++;
    }

    public String mostrarPolinomio(int n) {
        StringBuilder polinomio = new StringBuilder();
        if (esVacio(n)){
            polinomio.append("No existe polinomio en esa posicion para mostrar");
            return polinomio.toString();
        }else{
            NodoPolinomio p = cabezas[n-1].getLiga();
                
            boolean primero=true;
            while (!finRecorrido(p)) { //finRecorrido
                Termino termino = p.getTermino();
                double coef = termino.getC();
                int exp = termino.getE();
                // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
                if (coef >= 0 && !primero) {
                    polinomio.append("+");
                }
                if(exp!=0){
                    polinomio.append((int)coef).append("X^").append(exp);
                }else{
                    polinomio.append((int)coef);
                }
                p = p.getLiga();
                primero=false;
            }
        }
        return polinomio.toString(); 
    }    
            
    public double evaluarPolinomio (int n, int num){
        double resultado=0;
        NodoPolinomio recorrido = new NodoPolinomio();
        recorrido =cabezas[n-1].getLiga();
        
        while (!finRecorrido(recorrido)) {
            double coef = recorrido.getTermino().getC();
            int exp = recorrido.getTermino().getE();
            
            if(coef !=0){
                resultado+= (Math.pow(num,exp)*coef) ;
            }else{
                resultado+= coef;
            }

            recorrido= recorrido.getLiga();
        }
        return resultado;
    }
    
    public boolean esVacio (int n){
        boolean existe=true;
        if (cabezas[n-1].getLiga()==null){
            return existe;
        }
        existe=false;
        return existe;
    }
    
    
    public String derivarPolinomio(int n){
        StringBuilder polinomio = new StringBuilder();
        if (esVacio(n)){
            polinomio.append("No existe polinomio en esa posicion para derivar");
            return polinomio.toString();
        }else{
            NodoPolinomio p = cabezas[n-1].getLiga();
                
            boolean primero=true;
            while (!finRecorrido(p)) { 
                Termino termino = p.getTermino();
                double coef = termino.getC();
                int exp = termino.getE();
                // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
                if (coef > 0 && !primero && exp>0) {
                    polinomio.append("+");
                }
                if(exp>=2){
                    polinomio.append(((int)coef)*exp).append("X^").append(exp-1);
                }else if(exp==1){
                    polinomio.append((int)coef);
                }
                p = p.getLiga();
                primero=false;
            }
        }
        return polinomio.toString();
    }
    
    
    public void mostrarTodas (){
        StringBuilder polinomio = new StringBuilder();
        NodoPolinomio recorrido = new NodoPolinomio();
                
        //for(int i=0; i<cabezas.length;i++){
        int i=0  ;  
        while(i<cabezas.length) {   
            recorrido =cabezas[i].getLiga();
            if (esVacio(i+1)){
            polinomio.append("En la posicion "+(i+1)+" no hay polinomio registrado");
                System.out.println(polinomio);
                polinomio.setLength(0);
            
            }else{        
                boolean primero=true;
                while (!finRecorrido(recorrido)) { //finRecorrido
                Termino termino = recorrido.getTermino();
                double coef = termino.getC();
                int exp = termino.getE();
                // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
                if (coef >= 0 && !primero) {
                    polinomio.append("+");
                }
                if(exp!=0){
                    polinomio.append((int)coef).append("X^").append(exp);
                }else{
                    polinomio.append((int)coef);
                }
                recorrido = recorrido.getLiga();
                primero=false;
                }
                System.out.print("Polinomio en la posicion "+(i+1)+" > ");System.out.println(polinomio);
            polinomio.setLength(0);
            }
            i++;

        }   
    }
        
    private boolean finRecorrido(NodoPolinomio p) {
        return p == null;
    }




}