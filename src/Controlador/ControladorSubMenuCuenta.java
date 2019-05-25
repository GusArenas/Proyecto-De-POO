/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modulo.*;
import Vista.ImpresionSubMenuCuenta;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tenan
 */
public class ControladorSubMenuCuenta {
   
    Scanner teclado = new Scanner(System.in);
    
    public List<Consultorio> cobroConsultaGeneral(List <Consultorio> consultorios, Personas<Doctor> listaDoctor){
        ImpresionSubMenuCuenta impresionCuenta = new ImpresionSubMenuCuenta();
        int idPaciente, idDoctor=0, valid=0, opt;
        double tarifa=0, cargosExtra=0, pagoCompleto;
        
        idPaciente=impresionCuenta.pedirIdConsulta();
        
	for(int i=0; i<consultorios.size(); i++){
		if(idPaciente==consultorios.get(i).getIdPaciente()){
			idDoctor=consultorios.get(i).getIdDoctor();
			consultorios.get(i).setIdPaciente(0);
			valid=1;
			break;
		}
	}
	
	if(valid==1){
		for(int i=0; i<listaDoctor.obtenerCantidadDatos(); i++){
			if(idDoctor==listaDoctor.leerDatos(i).getId()){
				tarifa=listaDoctor.leerDatos(i).getTarifaDeConsulta();
				break;
			}
                        
		opt=impresionCuenta.cargosExtraConsultaGeneral();
                
		if(opt==1){
			cargosExtra=impresionCuenta.cantidadCargosExtra();
			}
		
		pagoCompleto=tarifa+cargosExtra;
		
                impresionCuenta.pagoCompleto(pagoCompleto);
			
	}
    } 
        else impresionCuenta.idNoEncontrado();

        return consultorios;
        
       
    }
    
    public List<Consultorio> cobroEstancia(List <Consultorio> consultorios){
        ImpresionSubMenuCuenta impresionCuenta = new ImpresionSubMenuCuenta();
        int idPaciente, valid=0, piso=0, dias=0, opt, optP;
        double precioCuarto=0, procedimientos=0, pagoCompleto;
        
        idPaciente=impresionCuenta.pedirIdEstancia();
	
	for(int i=0; i<consultorios.size(); i++){
		if(idPaciente==consultorios.get(i).getIdPaciente()){
			consultorios.get(i).setIdPaciente(0);
                        
                        if((consultorios.get(i).getId()>=11)&&(consultorios.get(i).getId()<=20)){
                            piso=2;
                        } else if(consultorios.get(i).getId()<=30){
                            piso=3;
                        } else if(consultorios.get(i).getId()<=40){
                            piso=4;
                        } else if(consultorios.get(i).getId()<=50){
                            piso=5;
                        }
                        
			valid=1;
			break;
		}
	}
	
	if(valid==1){
		switch(piso){
			case 2: precioCuarto=8000;
				break;
			case 3: precioCuarto=7000;
				break;
			case 4: precioCuarto=5000;
				break;
			case 5: precioCuarto=10000;
				break;
		}
		
		dias=impresionCuenta.diasEstancia();
 
		opt=impresionCuenta.decisionProcedimientos();
		if(opt==1){
			do{
			optP=impresionCuenta.procedimientos();
			
			switch(optP){
				case 1: procedimientos=procedimientos+5000;
					break;
                                case 2: procedimientos=procedimientos+3500;
                                        break;
                                case 3: procedimientos=procedimientos+12600;
                                        break;
                                case 4: procedimientos=procedimientos+6000;
                                        break;
                                case 5: procedimientos=procedimientos+12000;
                                        break;
                                case 6: procedimientos=procedimientos+8000;
                                        break;
                                case 7: procedimientos=procedimientos+15000;
                                        break;
                                case 8: procedimientos=procedimientos+20000;
                                        break;
                                case 9: procedimientos=procedimientos+5000;
                                        break;
                                default: impresionCuenta.errorProcedimiento();
			}

			opt=impresionCuenta.nuevoProcedimiento();
			}while(opt!=1);
			
			}
		
		pagoCompleto=(dias*precioCuarto)+(procedimientos);
		
		impresionCuenta.pagoCompleto(pagoCompleto);
			
	}
	else impresionCuenta.idNoEncontrado();
        
        return consultorios;

    }
    
}
