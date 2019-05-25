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
public class PacienteIngreso extends Datos{
    
    private int numSeguroSocial;
    private String descripcionDeEnfermedad;
    private String enfermedad;
    private int habitacion;

    public PacienteIngreso(int id, String nombre, String correo, int telefono, int numSeguroSocial, String descripcionDeEnfermedad, String enfermedad, int habitacion) {
        super(id, nombre, correo, telefono);
        this.numSeguroSocial = numSeguroSocial;
        this.descripcionDeEnfermedad = descripcionDeEnfermedad;
        this.enfermedad = enfermedad;
        this.habitacion = habitacion;
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

    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
    
    @Override
    public void imprimir(){
        System.out.println("\nId: "+ this.getId());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Numero Seguro Social: "+this.getNumSeguroSocial());
        System.out.println("Correo: "+this.getCorreo());
        System.out.println("Telefono: "+this.getTelefono());
        System.out.println("Descripcion de enfeermedad: "+this.getDescripcionDeEnfermedad());
        System.out.println("Enfermedad: "+this.getEnfermedad());
        System.out.println("Habitacion: "+this.getHabitacion());
    }
}
