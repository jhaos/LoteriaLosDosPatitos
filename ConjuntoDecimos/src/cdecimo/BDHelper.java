/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdecimo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sergio
 * 
 * La clase BDHelper gestiona un fichero de texto (base de datos) para los decimos.
 * La estructura de este fichero de texto es la siguiente:
 *        
 *        Numero del decimo;cantidad;codigo de barras
 *
 * Como ejemplo:
 *        12345;3;1245678901234567890;4
 * 
 * 
 */
public class BDHelper {
    
    private static String fichero;
    private File bd;
    private ArrayList<Decimo> lista_decimos_almacenados;
    
    BDHelper() throws IOException{
        this.fichero = "decimos.dat";
        bd = new File(fichero);
        if(!exists()) bd.createNewFile();
        System.out.println(bd.getAbsolutePath());
        lista_decimos_almacenados = getDecimos();
    }
    BDHelper(String nombre) throws IOException{
        this.fichero = nombre;
        bd = new File(fichero);
        lista_decimos_almacenados = getDecimos();
    }
    
    private boolean exists(){
        return bd.exists();
    }
    
    private BufferedReader openFile() throws FileNotFoundException, IOException{
        if(this.fichero != "" && this.exists()){
            FileReader f = new FileReader(this.fichero);
            BufferedReader b= new BufferedReader(f);
            return b;
        }
        return null;
    }
   
    private void writeFile(String texto, boolean override) throws IOException{
        // Parametros: Nombre de fichero (String) y si quiere ser sobreescrito (false) o añadido al final (true)
        BufferedWriter writer= new BufferedWriter(new FileWriter(this.fichero, override)); 

        writer.append(texto);
        writer.newLine();
        writer.close();
    }
    
    public boolean insertar(Decimo d) {
        boolean insertado = false;
        
        String numero = d.getNumeroDecimo();
               
        if(consultar(numero)==null){ //Si el numero no está en la base de datos
            System.out.println("Insertar nuevo");
            this.lista_decimos_almacenados.add(d);
            //writeFile(d.toBD());
            return true;
        }else{
            return false;
        } 
    }
    
    public void actualizar(Decimo d) {
        //String linea;
        //boolean encontrado = false;
        //BufferedReader b = this.openFile();
        //this.bd.delete();
             
        for(int i=0; i<this.lista_decimos_almacenados.size(); i++){
            System.out.println("linea "+i+": "+this.lista_decimos_almacenados.get(i).toString());
            
            if(d.getNumeroDecimo().equals(lista_decimos_almacenados.get(i).getNumeroDecimo()))
                this.lista_decimos_almacenados.set(i, d);
            //this.writeFile(lista_decimos_almacenados.get(i).toBD());
        }
       
        /*
        while ((linea = b.readLine())!=null){
            String[] parseo = linea.split(";");
            System.out.println("--------"+linea);
            if (!encontrado && d.getCodigoBarras().equals(parseo[2])){
                this.writeFile(d.toBD());
                encontrado = true;
            }else{
                this.writeFile(linea);
            }
        } */
       //b.close();
    }
    
    public boolean borrar(String numero, int cnt){
        boolean borrado = false;
        
        Decimo encontrado = consultar(numero);
        if(encontrado!= null && cnt>0){
            encontrado.aniadirVenta(cnt);
            encontrado.borrarCantidad(cnt);

            System.out.println("Borra numero");
        }
        
        /*if(numero.equals(consultar(numero).getNumeroDecimo())){ //Si el numero está en la base de datos
            /*BufferedReader b = this.openFile();
            String linea;
            while((linea=b.readLine())!=null){
                String[] parseo = linea.split(";");
                if(parseo.length == 3 && parseo[0] != numero){
                    this.writeFile(linea);
                }   
            }
            b.close();
            this.lista_decimos_almacenados.remove(d);

            borrado = true;
            
        } */   
       
        return borrado;
    }
   
    public void eliminar(String numero){
        for (Decimo d : this.lista_decimos_almacenados){
            if (d.getNumeroDecimo().equals(numero)){
                this.lista_decimos_almacenados.remove(d);
            } 
        }
    }
    
    public Decimo consultar(String numero_decimo) {     
        Decimo d= null;
        String linea;       

        if(numero_decimo.length() == 5){
            //Tenemos numero particular
            for(Decimo dLista: this.lista_decimos_almacenados){
                System.out.println(dLista.getNumeroDecimo()+"\n");
                if(dLista.getNumeroDecimo().equals(numero_decimo)){
                    System.out.println("Encontramos numero decimo");
                    d = dLista;
                    break;
                }
            }
        }
        else if(numero_decimo.length()>10){
            //TEnemos codigo de barras
            for(Decimo dLista: this.lista_decimos_almacenados){
                if(dLista.getCodigoBarras().equals(numero_decimo)){
                    System.out.println("Encontramos codigo de barras decimo");
                    d = dLista;
                    break;
                }
            }
        }
        return d;
        
        /*while( (linea=b.readLine())!=null){
            String[] parseo = linea.split(";");
            if(parseo.length == 3 ){

                if(numero_decimo.length()==5)
                    if(parseo[0].equals(numero_decimo)){
                        System.out.println("Habemus numero");
                        d = new Decimo();
                        d.setCodigoBarras(parseo[2]);
                        d.setNumeroDecimo(numero_decimo);
                        d.aumentarCantidad(Integer.parseInt(parseo[1]));
                        return d;
                    }
                if(numero_decimo.length()>10){
                    if(parseo[2].equals(numero_decimo)){
                        System.out.println("HAbemus codigo");
                        d = new Decimo();
                        d.setCodigoBarras(parseo[2]);
                        d.setNumeroDecimo(numero_decimo);
                        d.aumentarCantidad(Integer.parseInt(parseo[1]));
                        return d;
                    }
                }
            }
            
        }
        b.close();
        return d;*/
    }
        
    public int getCantidadDisponible(String numero_decimo) throws IOException{
        System.out.println(numero_decimo);
        Decimo d = consultar(numero_decimo);
        if(d!=null){
            return d.getCantidad();
        }else{
            return 0;
        }
    }
    public int getCantidadVendidos(String numero_decimo) throws IOException{
        Decimo d = consultar(numero_decimo);
        if(d!=null){
            System.out.println(d);
            return d.getTotalVendidos();
        }else{
            return 0;
        }
    }
    
    public int getCantidadTotal(){
        return this.lista_decimos_almacenados.size();
    }
    
    public ArrayList<Decimo> getDecimos() throws IOException{
        BufferedReader b = this.openFile();
        ArrayList<Decimo> decimos = new ArrayList<>();
        String linea;
        while( (linea=b.readLine())!=null){
            String[] parseo = linea.split(";");
            if(parseo.length == 4){
                Decimo d = new Decimo(parseo[0], parseo[2],Integer.parseInt(parseo[1]),Integer.parseInt(parseo[3]) );
                decimos.add(d);
            }
        }
        b.close();
        return decimos;
    }
    
    public ArrayList<Decimo> getDecimos(int cnt){
        
        ArrayList<Decimo> lista_cantidad = new ArrayList<>();
        
        for(Decimo d:this.lista_decimos_almacenados){
            if(d.getCantidad()>=cnt){
                lista_cantidad.add(d);
            }
        }
        return lista_cantidad;
        /*
        BufferedReader b = this.openFile();
        String linea;
        while( (linea=b.readLine())!=null){
            String[] parseo = linea.split(";");
            if(parseo.length == 3 && Integer.getInteger(parseo[1])>=cnt){
                this.lista_decimos_almacenados.add(new Decimo(parseo[0], parseo[2],Integer.getInteger(parseo[1])));
            }
        }
        BDHelper.cnt_total = lista_decimos_almacenados.size();
        b.close();
        return lista_decimos_almacenados;*/
    }

    public void save() throws IOException {
        if(this.bd.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else{
            System.out.println("El fichero no pudo ser borrado");
        }
        boolean override = false;
        for(Decimo d:this.lista_decimos_almacenados){
            System.out.println("Incluimos: "+d.toBD());
            this.writeFile(d.toBD(),override);
            if(!override) override = !override;
                
        }
    }
    
    public int totalVendidos(){
        int v=0;
        for(Decimo d:this.lista_decimos_almacenados){
            v+= d.getTotalVendidos();
        }
        return v;
    }

    ArrayList<Decimo> consultarTerminacion(String text) {
        ArrayList<Decimo> terminaciones = new ArrayList<>();
        for(Decimo decimo:this.lista_decimos_almacenados){
            String numero = decimo.getNumeroDecimo();
            if(numero.subSequence(5-text.length(),numero.length()).equals(text)){
                terminaciones.add(decimo);
            }
        }
        return terminaciones;
    }
    
    
}
