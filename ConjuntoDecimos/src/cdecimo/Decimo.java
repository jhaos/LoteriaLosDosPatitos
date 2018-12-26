package cdecimo;
import java.math.BigInteger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliu
 */
public class Decimo {
    private String numeroDecimo;
    private String codigoBarras;
    private int cantidad;
    private int cnt_vendidos;
    
    Decimo(){
        numeroDecimo = "";
        codigoBarras = "";
        cantidad = 0;
        cnt_vendidos = 0;
    }
    
    Decimo (String numero, String codigo){
        this.numeroDecimo = numero;//se necesita controlar el numero de digitos de todos los campos
        this.codigoBarras = codigo;
        this.cantidad = 0; 
        this.cnt_vendidos = 0;
    }

    Decimo (String numero, String codigo, int cnt, int cnt_vendidos){
        this.numeroDecimo = numero;
        this.codigoBarras = codigo;
        this.cantidad = cnt;   
        this.cnt_vendidos = cnt_vendidos;
    }

    
    String getNumeroDecimo() {
        return numeroDecimo;
    }

    String getCodigoBarras() {
        return codigoBarras;
    }

    int getCantidad() {
        return cantidad;
    }

    void setNumeroDecimo(String numeroDecimo) {
        this.numeroDecimo = numeroDecimo;
    }

    void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public int getTotalVendidos(){
        return this.cnt_vendidos;
    }
    public void setTotalVendidos(int cnt){
        this.cnt_vendidos = cnt;
    }
    
    
    public void aniadirVenta(int cnt){
        this.cnt_vendidos += cnt;
    }
    
    public void quitarVenta(int cnt){
        this.cnt_vendidos -= cnt;
    }
    
/*
    void aumentarCantidad() {
        this.cantidad += 1;
    }
    void insertarCantidad(int cantidad){
        this.cantidad += cantidad -1; //Esta esto bien??
    }*/
    
    void aumentarCantidad(){
        this.cantidad += 1;
    }
    void aumentarCantidad(int cnt){
        this.cantidad += cnt;
    }
    
    void borrarCantidad(int cantidad){
        
        this.cantidad -= cantidad;
        
        // No puede haber cantidades negativas, el tio no puede estar sin numeros
        if(this.cantidad < 0){
            this.cantidad = 0;
        }
    }
    
    void disminuirCantidad(){
        if (cantidad > 0)
            cantidad--;
        else
            cantidad = 0;
    }

    public String toBD(){
        return this.numeroDecimo+";"+String.valueOf(this.cantidad)+";"+this.codigoBarras+";"+String.valueOf(this.cnt_vendidos)+";";
    }
    
    @Override
    public String toString() {
        return "Decimo==>" + "Numero de decimo = " + numeroDecimo + ", codigo de barras = " + codigoBarras + ", cantidad = " + cantidad+", vendidos = "+cnt_vendidos;
    }
   

    
}
