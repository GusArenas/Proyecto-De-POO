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
 * @author tenan
 */
public class ImpresionSubMenuCuenta {
    
    Scanner teclado = new Scanner(System.in);
    
    public int pedirIdConsulta(){
        int idPaciente;    
        System.out.println("Introduzca el ID del paciente que terminó consulta general: ");
	idPaciente=teclado.nextInt();
	teclado.nextLine();
	
        return idPaciente;
    }
    
    public int cargosExtraConsultaGeneral(){
        System.out.println("Hubo cargos extra? (1) para si o (0) para no.");
	int opt=teclado.nextInt();
	teclado.nextLine();
        
        return opt;
    }
    
    public double cantidadCargosExtra(){
        System.out.println("De cuánto fueron los cargos?");
        double cargosExtra=teclado.nextDouble();
        teclado.nextLine();
        
        return cargosExtra;
}
    
    public void pagoCompleto(double pagoCompleto){
        System.out.println("Su cuenta total es de $" + pagoCompleto);
    }
    
    public void idNoEncontrado(){
        System.out.println("Error. No se encontró el ID ingresado. ");
    }
    
    public int pedirIdEstancia(){
        System.out.println("Introduzca el ID del paciente que terminó estancia en el hospital: ");
	int idPaciente=teclado.nextInt();
	teclado.nextLine();
        
        return idPaciente;
    }
    
    public int diasEstancia(){
        System.out.println("Cuantos dias se estuvo ingresado?");
	int dias=teclado.nextInt();
	teclado.nextLine();
        
        return dias;
    }
    
    public int decisionProcedimientos(){
        System.out.println("Hubo procedimientos extra? (1) para si o (0) para no. ");
	int opt=teclado.nextInt();
        teclado.nextLine();
        
        return opt;
    }
    
    public int procedimientos(){
        System.out.println("PROCEDIMIENTOS: \n1)Electrocardiograma\t$5,000\n2)Prueba de esfuerzo\t$3,500\n3)Apendicectomía\t$12,600\n4)Biopsias\t$6,000\n5)Bypass Gástrico\t$12,000\n6)Histerectomía\t$8,000\n7)Liposucción\t$15,000\n8)Transplante de córnea\t$20,000\n9)Ecocardiograma transesofágico\t$5,000\n\nElección: ");
	int optP=teclado.nextInt();
	teclado.nextLine();
        
        return optP;
    }
    
    public void errorProcedimiento(){
        System.out.println("Error. Introduzca un procedimiento válido.");
    }
    
    public int nuevoProcedimiento(){
        System.out.println("Desea agregar otro procedimiento? (1) para si y (0) para no.");
        int opt=teclado.nextInt();
        teclado.nextLine();
        
        return opt;
    }
}