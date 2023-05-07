/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioordenado;

import java.io.*;

/**
 *
 * @author suare
 */
public class ArbolBinarioordenado {

    class Nodo
    {
        int info;
        Nodo izq, der;
    }
    int sum;
    Nodo raiz;
    int cant;
    int altura;
    
    public ArbolBinarioordenado() {
        raiz = null;
    }
    
    public void insertar (int info) {
        if(!existe(info)) {
            Nodo nuevo;
            nuevo = new Nodo();
            nuevo.info = info;
            nuevo.izq = null;
                nuevo.der = null;
            if (raiz == null)
                raiz = nuevo;
            else {
                Nodo anterior = null, reco;
                reco = raiz;
                while (reco != null) {
                    anterior = reco;
                    if(info < reco.info)
                        reco = reco.izq;
                    else
                        reco = reco.der;
                }
                if (info < anterior.info)
                    anterior.izq = nuevo;
                else
                    anterior.der = nuevo;
            }
        }
    }
    
    public boolean existe(int info) {
        Nodo reco = raiz;
        while(reco!=null) {
            if(info==reco.info)
                return true;
            else
                if(info>reco.info)
                    reco=reco.der;
                else
                    reco=reco.izq;
        }
        return false;
    }
    private void imprimirEntre (Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.println(reco.info + "");
            imprimirEntre (reco.der);
        }
    }
    
    public void imprimirEntre () {
        imprimirEntre(raiz);
        System.out.println();
    }
    private void cantidad (Nodo reco) {
        if (reco!=null) {
            cant++;
            cantidad(reco.izq);
            cantidad(reco.der);
        }       
    }
    public int cantidad() {
        cant=0;
        cantidad(raiz);
        return cant;
    }
    private void cantidadNodosHoja(Nodo reco, int s) {
        if (reco!=null) {
            if (reco.izq==null && reco.der ==null){ 
                sum=s;
                sum=reco.info+sum;
                cant++;
            }
            cantidadNodosHoja(reco.izq,sum);
            cantidadNodosHoja(reco.der,sum);
        }
    }
    
    public int cantidadNodosHoja() {
        cant=0;
        cantidadNodosHoja(raiz,sum);
        return cant;
    }
    
    private void suma (Nodo reco, int s) {
        if (reco != null) {
            sum=s;
            suma(reco.izq, sum);           
            suma(reco.der, sum);
            sum=reco.info+sum;
            System.out.println(sum + "");
        }
    }
    
    public void suma () {        
        suma(raiz,sum);
    }
    
   private void imprimirEntreConNivel (Nodo reco, int nivel) {
       if (reco != null) {
           imprimirEntreConNivel(reco.izq,nivel+1);
           System.out.println(reco.info + " ("+nivel+") -");
           imprimirEntreConNivel(reco.der, nivel+1);
       }
   }
   public void imprimirEntreConNivel() {
       imprimirEntreConNivel(raiz,1);
       System.out.println("");
   }
   
   private void retornarAltura (Nodo reco, int nivel) {
       if(reco != null) {
           retornarAltura(reco.izq, nivel+1);
           if (nivel>altura)
               altura=nivel;
           retornarAltura(reco.der,nivel+1);           
       }
   }
   public int retornarAltura() {
       altura = 0;
       retornarAltura(raiz,1);
       return altura;
   }
   public void mayorValor() {
       if (raiz!=null) {
           Nodo reco=raiz;
           while (reco.der!=null)
               reco=reco.der;
           System.out.println("Mayor valor del arbol:" +reco.info);
       }
   }
   
public void menorValor() {
       if (raiz!=null) {
           Nodo reco=raiz;
           while (reco.izq!=null)
               reco=reco.izq;
           System.out.println("Menor valor del arbol:" +reco.info);
       }
   }

public void borrarMayor() {
       if (raiz!=null) {
           if(raiz.der==null)
               raiz=raiz.izq;
           else {
               Nodo atras = raiz;
               Nodo reco =raiz.der;
               while (reco.der!=null) {
                   atras = reco;
                   reco = reco.der; 
               }
               atras.der = reco.izq;
           }
       }
   }
   
   public void borrarMenor() {
       if (raiz!=null) {
           if(raiz.izq==null)
               raiz=raiz.der;
           else {
               Nodo atras = raiz;
               Nodo reco =raiz.izq;
               while (reco.izq!=null) {
                   atras = reco;
                   reco = reco.izq;                           
               }
               atras.izq = reco.der;
           }
       }
   }
   
private void imprimirPosEntre (Nodo reco) {
        if (reco != null) {
            imprimirPosEntre(reco.izq);            
            imprimirPosEntre (reco.der);
            System.out.println(reco.info + "");
        }
    }
    
    public void imprimirPosEntre () {
        imprimirPosEntre(raiz);
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        ArbolBinarioordenado abo = new ArbolBinarioordenado();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        abo.insertar(100);
        abo.insertar(50);
        abo.insertar(22);
        abo.insertar(72);
        abo.insertar(151);
        System.out.println("Impresion in-orden: ");
        abo.imprimirEntre();
        System.out.println("Cantidad de nodos del arbol: "+abo.cantidad());
        System.out.println("Cantidad de nodos hoja: "+abo.cantidadNodosHoja());
        System.out.println("Sumatoria: "+abo.sum);
        System.out.println("Impresion entre orden junto al nivel del nodo.");
        abo.imprimirEntreConNivel();/*
        System.out.println("Altura del arbol:");
        System.out.println(abo.retornarAltura());
        abo.mayorValor();
        abo.menorValor();
        
        System.out.println("Impresion pos-orden:");
        abo.imprimirPosEntre();       
        
        abo.borrarMenor();        
        System.out.println("Luego de borrar el menor:");
        abo.imprimirEntre();
        abo.borrarMayor();
        System.out.println("Luego de borrar el mayor:");
        abo.imprimirEntre();*/
        
    }
    
}
