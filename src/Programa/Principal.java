/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import Modulo.Doctor;
import Modulo.PacienteConsulta;
import Modulo.PacienteIngreso;
import Modulo.Personas;
import Vista.ImprimirMenus;
import Controlador.ControladorSubMenuDoctores;
import Controlador.ControladorPacientesConsulta;
import Controlador.ControladorPacientesIngreso;
import Modulo.Consultorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gusar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personas<Doctor> doctores = new Personas<>();
        Personas<PacienteConsulta> pacientesConsulta = new Personas<>();
        Personas<PacienteIngreso> pacientesIngreso = new Personas<>();
        List<Consultorio> consultorios = new ArrayList<>();
        ImprimirMenus menus = new ImprimirMenus();
        ControladorSubMenuDoctores controlSubMenuDoctores = new ControladorSubMenuDoctores();
        ControladorPacientesConsulta controlsubMenuPacientesConsulta= new ControladorPacientesConsulta();
        ControladorPacientesIngreso controlSubMenuPacientesIngreso=new ControladorPacientesIngreso();
        int opt1=0, opt2, opt3;
        consultorios=controlSubMenuDoctores.iniciacionConsultorio(consultorios);
        
        do{
            menus.menuPrincipal(opt1);
            opt1=scanner.nextInt();
            switch(opt1){
                case 1:{
                    do{
                        menus.subMenuDoctor();
                        opt2=scanner.nextInt();
                        switch(opt2){
                            case 1:{
                                doctores=controlSubMenuDoctores.nuevoDoctor(doctores, pacientesIngreso, pacientesConsulta, consultorios);
                            }break;
                            case 2:{
                                controlSubMenuDoctores.asignacionDoctor(doctores, consultorios);
                                consultorios=controlSubMenuDoctores.getConsultorios();
                                doctores=controlSubMenuDoctores.getDoctores();
                            }break;
                            case 3:
                                controlSubMenuDoctores.editarDoctor(doctores, consultorios);
                                
                            break;
                        }
                    }while(opt2!=4);
                }break;
                case 2:{
                    opt3=0;
                     do{ 
                         
                        menus.subMenuConsultaGeneral();
                        opt3= scanner.nextInt();
                      switch(opt3)
                        {
                            case 1: {
                                pacientesConsulta=controlsubMenuPacientesConsulta.nuevoPacienteConsulta(doctores,pacientesIngreso,pacientesConsulta, consultorios);
                                controlsubMenuPacientesConsulta.asignacionConsultorio(pacientesConsulta, consultorios);
                                consultorios=controlsubMenuPacientesConsulta.getConsultorios();
                                doctores=controlsubMenuPacientesConsulta.getDoctores();
                            }break;
                        }
                     }
                     while(opt3!=2);
                    
                    
                }break;  
                case 3:{
                    opt3=0;
                    
                     do
                     {  menus.subMenuIngreso();
                        opt3= scanner.nextInt();
                         switch(opt3)
                        {
                            case 1: 
                            {
                                pacientesIngreso=controlSubMenuPacientesIngreso.nuevoPacienteIngreso(doctores, pacientesIngreso, pacientesConsulta, consultorios);
                                controlSubMenuPacientesIngreso.asignacionHabitacion(pacientesIngreso, consultorios);
                                consultorios=controlSubMenuPacientesIngreso.getConsultorios();
                                doctores=controlSubMenuPacientesIngreso.getDoctores();    
                            }break;
                        }
                     }
                     while(opt3!=2);
                    
                    
                }break;    
            }
        }while(opt1!=6);
    }
    
}
