package cdecimo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cdecimo.Decimo;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author juliu
 */
public class ConjuntoDecimos {
    private ArrayList<Decimo> conjunto = new ArrayList();
    private static final ConjuntoDecimos instancia = new ConjuntoDecimos();
    
    public static ConjuntoDecimos getInstance(){
        return ConjuntoDecimos.instancia;
    }
    
    // Inserta un decimo en el conjunto
   void insertar(Decimo dec){
       conjunto.add(dec);
       int i = conjunto.indexOf(dec);
       conjunto.get(i).aumentarCantidad();
       System.out.println("se ha aniadido");
   }
   // Inserta un decimo que ya existe en el mazo
   void insertar_existente(String cod){
       for (Decimo decimo : conjunto) {
           if (decimo.getCodigoBarras() == cod){
               decimo.aumentarCantidad();
           }
       }
   }
 
  // Devuelve true si el decimo esta, false si no, a partir del codigo de barras
   boolean decimo_esta(String codBarras){
       boolean esta = false;
       for (Decimo decimo : conjunto) {
           if (decimo.getCodigoBarras() == codBarras){
               esta = true;
           }
       }
       return esta;
   }
  // Devuelve true si el decimo esta false si no a partir del numero   
    boolean decimo_esta_numero(String numero){
       boolean esta = false;
       for (Decimo decimo : conjunto) {
           if (decimo.getNumeroDecimo()== numero){
               esta = true;
           }
       }
       return esta;
   }

  // Funcion de borrado si la cantidad es 1 lo borra del mazo sino resta 1 a la cantidad
    void borrar(String numero){
        if (conjunto.size() == 1){
            conjunto.remove(0);
        }else{         
            for (int i = 0; i < conjunto.size(); ++i){
                if (conjunto.get(i).getNumeroDecimo() == numero){
                    if (conjunto.get(i).getCantidad() == 1){
                        conjunto.remove(conjunto.get(i));
                        System.out.println("quitado");
                    }else{
                        conjunto.get(i).disminuirCantidad();
                    }
                }
            }
        }
    }
    //Busca el decimo a partir del numero
    Decimo buscarDecimo (String numero){
        Decimo dec = new Decimo();
        for (Decimo decimo : conjunto) {
            if(decimo.getNumeroDecimo() == numero)
                dec = decimo;
        }
        return dec;
    }
    //Busca el decimo a partir del codigo de barras
    Decimo buscarDecimoCodigo (String codigoBarras){
        Decimo dec = new Decimo();
        for (Decimo decimo : conjunto) {
            if(decimo.getCodigoBarras() == codigoBarras)
                dec = decimo;
        }
        return dec;
    }
    //Devuelve la cantidad restante de un decimo a partir de un numero
    int cantidadDecimo (String numero){
        int cantidad = 0;
        for (Decimo decimo : conjunto) {
            if(decimo.getNumeroDecimo() == numero)
                cantidad = decimo.getCantidad();
        }
        System.out.println(cantidad);
        return cantidad;
    }
    //Devuelve la cantidad restante de un decimo a partir del codigo de barras
    int cantidadDecimoCod (String cod){
        int cantidad = 0;
        for (Decimo decimo : conjunto) {
            if(decimo.getCodigoBarras() == cod)
                cantidad = decimo.getCantidad();
        }
        System.out.println(cantidad);
        return cantidad;
    }
    
    /*int codigoBarras (int numero){
        int codigo = 0;
        for (Decimo decimo : conjunto) {
            if(decimo.getNumeroDecimo() == numero)
                codigo = decimo.getCodigoBarras();
        }
        return codigo;
    }*/

    @Override
    public String toString() {
        String cadena = "";
        for (Decimo decimo : conjunto) {
            cadena += decimo.toString();
            cadena += "\n";
        }
        return cadena;
    }

}
