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
public class PacienteConsulta extends Datos{
    
    private int numSeguroSocial;
    private String descripcionDeEnfermedad;
    private int Consultorio;

    public PacienteConsulta(int id, String nombre, String correo, int telefono, int numSeguroSocial, String descripcionDeEnfermedad, int Consultorio) {
        super(id, nombre, correo, telefono);
        this.numSeguroSocial = numSeguroSocial;
        this.descripcionDeEnfermedad = descripcionDeEnfermedad;
        this.Consultorio = Consultorio;
    }
    
    
    public int getNumSeguroSocial() {
        return numSeguroSocial;
    }
    public void setNumSeguroSocial(int numSeguroSocial) {
        this.numSeguroSocial = numSeguroSocial;
    }
    
    public String getDescripcionDeEnfermedad() {
        return descripcionDeEnfermedad;
    }
    public void setDescripcionDeEnfermedad(String descripcionDeEnfermedad) {
        this.descripcionDeEnfermedad = descripcionDeEnfermedad;
    }

    public int getConsultorio() {
        return Consultorio;
    }
    public void setConsultorio(int Consultorio) {
        this.Consultorio = Consultorio;
    }
    
    @Override
    public void imprimir(){
        System.out.println("\nId: "+ this.getId());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Numero Seguro Social: "+this.getNumSeguroSocial());
        System.out.println("Correo: "+this.getCorreo());
        System.out.println("Telefono: "+this.getTelefono());
        System.out.println("Descripcion de enfeermedad: "+this.getDescripcionDeEnfermedad());
        System.out.println("Consultorio: "+this.getConsultorio());
    }
}
