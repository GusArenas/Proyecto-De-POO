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
public class Consultorio {
    private int id;
    private int claveConsultorio;
    private int idDoctor;
    private int idPaciente;
    
    public Consultorio(int i){
        this.claveConsultorio=i;
        this.idDoctor=0;
        this.idPaciente=0;
    }
    
    public Consultorio(int id, int claveConsultorio, int idDoctor, int idPaciente) {
        this.id = id;
        this.claveConsultorio = claveConsultorio;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getClaveConsultorio() {
        return claveConsultorio;
    }
    public void setClaveConsultorio(int claveConsultorio) {
        this.claveConsultorio = claveConsultorio;
    }
    
    public int getIdDoctor() {
        return idDoctor;
    }
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public void imprimir(){
        System.out.println("\nId: "+this.id);
        System.out.println("Clave consultorio: "+this.claveConsultorio);
        System.out.println("Id del doctor: "+this.idDoctor);
        System.out.println("Id del paciente: "+this.idPaciente);
    }
}
