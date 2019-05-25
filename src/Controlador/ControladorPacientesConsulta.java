/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.ImpresionSubMenuPacientesConsulta;
import Modulo.*;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Laura Mayte
 */
public class ControladorPacientesConsulta 
{
    private Personas<Doctor> doctores = null;
    private Personas<PacienteIngreso> pacientesIngreso = null;
    private Personas<PacienteConsulta> pacientesConsulta = null;
    private List<Consultorio> consultorios=null;
    private int id, id2, index, index2, inicio, fin, cont=0;
   
    
     public Personas<PacienteConsulta> nuevoPacienteConsulta(Personas<Doctor> doctores, Personas<PacienteIngreso> pacientesIngreso, Personas<PacienteConsulta> pacientesConsulta, List<Consultorio> consultorios)
     {     
        ImpresionSubMenuPacientesConsulta impresionMenu = new ImpresionSubMenuPacientesConsulta();
        ControladorArchivos archivoPacienteConsulta = new ControladorArchivos();
        int validacion=0;
        this.doctores=doctores;
        this.pacientesConsulta=pacientesConsulta;
        this.pacientesIngreso=pacientesIngreso;
        this.consultorios=consultorios;
        PacienteConsulta pacienteConsultaAux;
        impresionMenu.saltosDeLinea();
        do{
            if(validacion==1)
                impresionMenu.avisoIdExistente();
            validacion=0;
            this.id=impresionMenu.peticionId();
            for(int i=0;i<doctores.obtenerCantidadDatos();i++)
            {
                if(doctores.leerDatos(i).getId()==this.id)
                {
                    validacion=1;
                    break;
                }
            }
            if(validacion!=1)
            {
                for(int i=0;i<pacientesIngreso.obtenerCantidadDatos();i++)
                {
                    if(pacientesIngreso.leerDatos(i).getId()==this.id){
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1)
            {
                for(int i=0;i<pacientesConsulta.obtenerCantidadDatos();i++){
                    if(pacientesConsulta.leerDatos(i).getId()==this.id){
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1)
            {
                for(int i=0;i<consultorios.size();i++)
                {
                    if(consultorios.get(i).getId()==this.id)
                    {
                        validacion=1;
                        break;
                    }
                }
            }
            if(validacion!=1)
            {
                if(this.id==0)
                    validacion=1;
            }
            
        }while(validacion!=0);
        pacienteConsultaAux=impresionMenu.peticionInformacion();
        pacienteConsultaAux.setId(this.id);
        this.pacientesConsulta.aniadirDatos(pacienteConsultaAux);
        archivoPacienteConsulta.guardarDatosPacienteConsulta(this.pacientesConsulta);
        impresionMenu.avisoSeaniadioCorrectamente();
        
        return this.pacientesConsulta;
    }
     
     public void asignacionConsultorio(Personas<PacienteConsulta> pacientesConsulta, List<Consultorio> consultorios)
     {  String especialidad="";
        this.pacientesConsulta=pacientesConsulta;
        this.consultorios=consultorios;
        Consultorio consultorioAux=new Consultorio(0);
        int validacion=0, disponible;
        //
        ImpresionSubMenuPacientesConsulta impresionPacientesConsulta= new ImpresionSubMenuPacientesConsulta();
        impresionPacientesConsulta.saltosDeLinea();
        disponible=impresionPacientesConsulta.impresionDeConsultoriosDisponibles(this.consultorios, especialidad);
        if(disponible==1){
            //Validacion del Id del doctor
            do{
                if(validacion==1){
                    impresionPacientesConsulta.avisoIdNoExistente();
                }
                validacion=0;
                this.id=impresionPacientesConsulta.peticionId();
                for(int i=0;i<pacientesConsulta.obtenerCantidadDatos();i++){
                    if(pacientesConsulta.leerDatos(i).getId()==this.id){
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
           
            for(int i=0;i<pacientesConsulta.obtenerCantidadDatos();i++){
                if(pacientesConsulta.leerDatos(i).getId()==this.id){
                    this.index=i;
                    break;
                }
            }
            
            disponible=impresionPacientesConsulta.impresionDeConsultoriosDisponibles(this.consultorios, doctores.leerDatos(this.index).getEspecialidad());
            if(disponible==1){
                inicioFinEspecialidad(doctores.leerDatos(this.index).getEspecialidad());
               
                validacion=0;
                do{
                    if(validacion==1){
                        impresionPacientesConsulta.avisoIdNoExistente();
                    }
                    validacion=1;
                    this.id2=impresionPacientesConsulta.peticionId();
                    for(int i=this.inicio;i<this.fin;i++){
                        if(consultorios.get(i).getId()==this.id2){
                            validacion=0;
                            break;
                        }
                    }
                }while(validacion!=0);
                consultorios.get((this.id2-1)).setIdDoctor(this.id);
                impresionPacientesConsulta.avisoSeAsignoCorrectamente();
            }
        }
        this.pacientesConsulta=pacientesConsulta;
        this.consultorios=consultorios;
        ControladorArchivos archivosConsultorios = new ControladorArchivos();
        archivosConsultorios.guardarDatosConsultorios(consultorios);
    } 
     
     
     
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
