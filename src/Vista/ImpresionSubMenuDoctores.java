/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modulo.Consultorio;
import Modulo.Doctor;
import Modulo.Personas;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gusar
 */
public class ImpresionSubMenuDoctores {
    private int id;
    private String nombre;
    private String especialidad;
    private String correo;
    private int telefono;
    private double tarifaDeConsulta;
    public Doctor peticionInformacion(){
        int opt;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre: ");
        this.nombre=scanner.nextLine();
        System.out.println("Introduzca el correo: ");
        this.correo=scanner.nextLine();
        do{
            System.out.println("Introduzca la especialidad: \n1)Consultas Generales. \n2)Cardiología \n3)Pediatría \n4)Urgencias \n5)Cirugía");
            opt=scanner.nextInt();
        }while(opt<1 && opt>5);
        switch(opt){
            case 1:this.especialidad="Consultas generales";
                break;
            case 2:this.especialidad="Cardiología";
                break;
            case 3:this.especialidad="Pediatría";
                break;
            case 4:this.especialidad="Urgencias";
                break;
            case 5:this.especialidad="Cirugía";
                break;
        }
        System.out.println("Introduzca el teléfono: ");
        this.telefono=scanner.nextInt();
        System.out.println("Introduzca la tarifa de consulta: ");
        this.tarifaDeConsulta=scanner.nextDouble();
        return new Doctor(0, this.nombre, this.especialidad, this.correo, this.telefono, this.tarifaDeConsulta);
    }
    
    public int peticionId(){
        Scanner scanner = new Scanner(System.in);
        int idAux;
        System.out.println("Introduzca el id: ");
        idAux=scanner.nextInt();
        return idAux;
    }
    
    public void avisoIdExistente(){
        System.out.println("\nAVISO: El Id que introdujo ya está en uso.\n");
    }
    
    public void avisoIdNoExistente(){
        System.out.println("\nAVISO: El Id que introdujo no esta el base de datos.\n");
    }
    
    public void avisoNoHayEspacio(){
        System.out.println("\nAVISO: Todas la consultas estan ocupadas.\n");
    }
    
    public void avisoSeaniadioCorrectamente(){
        System.out.println("\nAVISO: Se añadio correctamente el doctor.\n");
    }
    
    public void avisoSeAsignoCorrectamente(){
        System.out.println("\nAVISO: Se asigno correctamente el doctor.\n");
    }
    
    public int impresionDeDoctoresDisponibles(Personas<Doctor> doctores, List<Consultorio> consultorios){
        int validacion, returnValidacion=0;
        System.out.println("\nDoctores Discponibles: ");
        for(int i=0; i<doctores.obtenerCantidadDatos();i++){
            validacion=0;
            for(int j=0; j<consultorios.size();j++){
                if(doctores.leerDatos(i).getId()==consultorios.get(j).getIdDoctor()){
                    validacion=1;
                    break;
                }
            }
            if(validacion!=1){
                doctores.leerDatos(i).imprimir();
                returnValidacion=1;
            }
        }
        return returnValidacion;
    }
    
    public int impresionDeConsultoriosDisponibles(List<Consultorio> consultorios, String especialidad){
        int returnValidacion=0, i=0, f=0;
        switch(especialidad){
            case "Consultas generales":{
                i=0;
                f=10;
            }break;
            
            case "Cardiología":{
                i=10;
                f=20;
            }break;
           
            case "Pediatría":{
                i=20;
                f=30;
            }break;
            
            case "Urgencias":{
                i=30;
                f=40;
            }break;
            
            case "Cirugía":{
                i=40;
                f=50;
            }break;
        }
        System.out.println("\nConsultorios: ");
        for(int j= i;j<f;j++){
            if(consultorios.get(j).getIdDoctor()==0){
                consultorios.get(j).imprimir();
                returnValidacion=1;
            }
        }
        return returnValidacion;
    }
    
    public void saltosDeLinea(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
