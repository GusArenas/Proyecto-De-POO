/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gusar
 * @param <T>
 */
public class Personas<T extends Datos>{

    private List<T> datos = new ArrayList();
    
    public void aniadirDatos(T x){
        this.datos.add(x);
    }
    
    public void eliminarDatos(int x){
        this.datos.remove(x);
    }
    
    public T leerDatos(int x){
        return this.datos.get(x);
    }
    
    public int obtenerCantidadDatos(){
        return this.datos.size();
    }
    
    public void editarDatos(int index, T x){
        this.datos.set(index, x);
    }
}