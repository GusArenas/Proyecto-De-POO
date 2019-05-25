/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modulo.*;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Laura Mayte
 */
public class ImpresionSubMenuPacienteInterno 
{   private int id;
    private String nombre;
    private String correo;
    private int telefono;
    private int numSeguroSocial;
    private String descripcionDeEnfermedad;
    private String enfermedad;
    private int habitacion;
    
    public PacienteIngreso peticionInformacion(){
        int opt;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre: ");
        this.nombre=scanner.nextLine();
        System.out.println("Introduzca el correo: ");
        this.correo=scanner.nextLine();
        System.out.println("Introduzca el teléfono: ");
        this.telefono=scanner.nextInt();
        System.out.println("Introduzca el numero de Seguro Social: ");
        this.numSeguroSocial=scanner.nextInt();
        System.out.println("Introduzca descricpión de enfermedad: ");
        this.descripcionDeEnfermedad=scanner.nextLine();
        scanner.nextLine();
        System.out.print("\n\tIngrese enfermedad: ");
         this.enfermedad= scanner.next();
        System.out.print("\n\tIngrese #de habitacion: ");
        this.habitacion= scanner.nextInt();
        //System.out.println("Introduzca el consultorio: ");
        //this.Consultorio=scanner.nextInt();
        return new PacienteIngreso(0, this.nombre, this.correo, this.telefono, this.numSeguroSocial, this.descripcionDeEnfermedad, this.enfermedad, this.habitacion);
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
