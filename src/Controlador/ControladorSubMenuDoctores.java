/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modulo.*;
import Vista.ImpresionSubMenuDoctores;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gusar
 */
public class ControladorSubMenuDoctores {
    private Personas<Doctor> doctores = null;
    private Personas<PacienteIngreso> pacientesIngreso = null;
    private Personas<PacienteConsulta> pacientesConsulta = null;
    private List<Consultorio> consultorios=null;
    private int id, id2, index, index2, inicio, fin, cont=0;
    private String especialidad;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Personas<Doctor> nuevoDoctor(Personas<Doctor> doctores, Personas<PacienteIngreso> pacientesIngreso, Personas<PacienteConsulta> pacientesConsulta, List<Consultorio> consultorios){     
        ImpresionSubMenuDoctores impresionSubMenuDoctores = new ImpresionSubMenuDoctores();
        ControladorArchivos archivoDoctor = new ControladorArchivos();
        int validacion=0;
        this.doctores=doctores;
        this.pacientesConsulta=pacientesConsulta;
        this.pacientesIngreso=pacientesIngreso;
        this.consultorios=consultorios;
        Doctor doctorAux;
        impresionSubMenuDoctores.saltosDeLinea();
        do{
            if(validacion==1)
                impresionSubMenuDoctores.avisoIdExistente();
            validacion=0;
            this.id=impresionSubMenuDoctores.peticionId();
            for(int i=0;i<doctores.obtenerCantidadDatos();i++){
                if(doctores.leerDatos(i).getId()==this.id){
                    validacion=1;
                    break;
                }
            }
            if(validacion!=1){
                for(int i=0;i<pacientesIngreso.obtenerCantidadDatos();i++){
                    if(pacientesIngreso.leerDatos(i).getId()==this.id){
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1){
                for(int i=0;i<pacientesConsulta.obtenerCantidadDatos();i++){
                    if(pacientesConsulta.leerDatos(i).getId()==this.id){
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1){
                for(int i=0;i<consultorios.size();i++){
                    if(consultorios.get(i).getId()==this.id){
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1){
                if(this.id==0)
                    validacion=1;
            }
        }while(validacion!=0);
        doctorAux=impresionSubMenuDoctores.peticionInformacion();
        doctorAux.setId(this.id);
        this.doctores.aniadirDatos(doctorAux);
        archivoDoctor.guardarDatosDoctor(this.doctores);
        impresionSubMenuDoctores.avisoSeaniadioCorrectamente();
        return this.doctores;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void asignacionDoctor(Personas<Doctor> doctores, List<Consultorio> consultorios){
        this.doctores=doctores;
        this.consultorios=consultorios;
        Consultorio consultorioAux=new Consultorio(0);
        int validacion=0, disponible;
        //
        ImpresionSubMenuDoctores impresionSubMenuDoctores = new ImpresionSubMenuDoctores();
        impresionSubMenuDoctores.saltosDeLinea();
        disponible=impresionSubMenuDoctores.impresionDeDoctoresDisponibles(this.doctores, this.consultorios);
        if(disponible==1){
            /*Validacion del Id del doctor*/
            do{
                if(validacion==1){
                    impresionSubMenuDoctores.avisoIdNoExistente();
                }
                validacion=0;
                this.id=impresionSubMenuDoctores.peticionId();
                for(int i=0;i<doctores.obtenerCantidadDatos();i++){
                    if(doctores.leerDatos(i).getId()==this.id){
                        validacion=0;
                        break;
                    }
                    else
                        validacion=1;
                }
                if(validacion==0){
                    for(int i=0;i<consultorios.size();i++){
                        if(consultorios.get(i).getIdDoctor()==this.id){
                            validacion=1;
                            break;
                        }
                    }
                }
                
            }while(validacion!=0);
            /*Obtener el index del doctor*/
            for(int i=0;i<doctores.obtenerCantidadDatos();i++){
                if(doctores.leerDatos(i).getId()==this.id){
                    this.index=i;
                    break;
                }
            }
            
            disponible=impresionSubMenuDoctores.impresionDeConsultoriosDisponibles(this.consultorios, doctores.leerDatos(this.index).getEspecialidad());
            if(disponible==1){
                inicioFinEspecialidad(doctores.leerDatos(this.index).getEspecialidad());
                /*Introduccion del id del consultorio*/
                validacion=0;
                do{
                    if(validacion==1){
                        impresionSubMenuDoctores.avisoIdNoExistente();
                    }
                    validacion=1;
                    this.id2=impresionSubMenuDoctores.peticionId();
                    for(int i=this.inicio;i<this.fin;i++){
                        if(consultorios.get(i).getId()==this.id2){
                            validacion=0;
                            break;
                        }
                    }
                }while(validacion!=0);
                consultorios.get((this.id2-1)).setIdDoctor(this.id);
                impresionSubMenuDoctores.avisoSeAsignoCorrectamente();
            }
        }
        this.doctores=doctores;
        this.consultorios=consultorios;
        ControladorArchivos archivosConsultorios = new ControladorArchivos();
        archivosConsultorios.guardarDatosConsultorios(consultorios);
    }
    
    public void editarDoctor(Personas<Doctor> doctores, List<Consultorio> consultorios){
       String nombredoctor,correo,especialidad;
       int telefono,id;
       double tarifa;
        Scanner dato=new Scanner(System.in);
       System.out.print("Ingrese el nombre del doctor a editar:");
       nombredoctor=dato.next();
       for(int i=0;i<doctores.obtenerCantidadDatos();i++){
       if(doctores.leerDatos(i).getNombre().equals(nombredoctor)){
                System.out.print("Ingrese el nuevo ID del doctor: ");
                id=dato.nextInt();
                System.out.print("Ingrese la nueva especialidad del doctor: ");
                especialidad=dato.next();
                System.out.print("Ingrese el nuevo correo del doctor: ");
                correo=dato.next();
                System.out.print("Ingrese el nuevo telefono del doctor: ");
                telefono=dato.nextInt();   
                System.out.print("Ingrese la nueva tarifa del doctor: ");
                tarifa=dato.nextDouble();
                doctores.editarDatos(i, new Doctor(id, nombredoctor, especialidad, correo, telefono, tarifa));
                break;
                }                    
       }
        
    }
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Personas<Doctor> getDoctores() {
        return doctores;
    }
    public void setDoctores(Personas<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Personas<PacienteIngreso> getPacientesIngreso() {
        return pacientesIngreso;
    }
    public void setPacientesIngreso(Personas<PacienteIngreso> pacientesIngreso) {
        this.pacientesIngreso = pacientesIngreso;
    }

    public Personas<PacienteConsulta> getPacientesConsulta() {
        return pacientesConsulta;
    }
    public void setPacientesConsulta(Personas<PacienteConsulta> pacientesConsulta) {
        this.pacientesConsulta = pacientesConsulta;
    }

    public List<Consultorio> getConsultorios() {
        return consultorios;
    }
    public void setConsultorios(List<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }
    
    public List<Consultorio> iniciacionConsultorio(List<Consultorio> consultorios){
        for(int i=0;i<50;i++){
            consultorios.add(new Consultorio((i+1)));
            consultorios.get((i)).setId((i+1));
        }
        return consultorios;
    }
    private void inicioFinEspecialidad(String especialidad){
        switch(especialidad){
            case "Consultas generales":{
                this.inicio=0;
                this.fin=10;
            }break;

            case "Cardiología":{
                this.inicio=10;
                this.fin=20;
            }break;

            case "Pediatría":{
                this.inicio=20;
                this.fin=30;
            }break;

            case "Urgencias":{
                this.inicio=30;
                this.fin=40;
            }break;

            case "Cirugía":{
                this.inicio=40;
                this.fin=50;
            }break;
        }
    }
}
