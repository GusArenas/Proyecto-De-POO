/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

/**
 *
 * 
 */
public class Doctor extends Datos{
   
    private String especialidad;
    private double tarifaDeConsulta;

    public Doctor(int id, String nombre, String especialidad, String correo, int telefono, double tarifaDeConsulta) {
        super(id, nombre, correo, telefono);
        this.especialidad = especialidad;
        this.tarifaDeConsulta = tarifaDeConsulta;
    }
    

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getTarifaDeConsulta() {
        return tarifaDeConsulta;
    }
    public void setTarifaDeConsulta(double tarifaDeConsulta) {
        this.tarifaDeConsulta = tarifaDeConsulta;
    }
    
    @Override
    public void imprimir(){
        System.out.println("\nId: "+ this.getId());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Especialidad: "+this.getEspecialidad());
        System.out.println("Correo: "+this.getCorreo());
        System.out.println("Telefono: "+this.getTelefono());
        System.out.println("Tarifa de consulta: "+this.getTarifaDeConsulta());
    }
}
