/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Gusar
 */
public class ImprimirMenus {
    public void menuPrincipal(int opc){
        if(opc!=0)
            saltosDeLinea();
        System.out.println("1)Doctor. \n2)Consulta general. \n3)Ingreso. \n4)Cuenta. \n5)Búsquedas. \n6)Salir. \n\nElección:");
    }
    
    public void subMenuDoctor(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ DOCTOR \n\n1)Nuevo doctor. \n2)Asignación doctor. \n3)Editar doctor. \n4)Regresar a menú principal. \n\nElección:");
    }
    
    public void subMenuConsultaGeneral(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ CONSULTA GENERAL \n\n1)Datos del paciente. \n2)Regresar \n\nElección:");
    }
    
    public void subMenuIngreso(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ INGRESO \n\n1)Datos del paciente. \n2)Regresar\n\nElección:");
    }
    
    public void subMenuCuenta(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ CUENTA \n\n1)Cobro de consulta general. \n2)Cobro estancia. \n\nElección:");
    }
    
    public void subMenuBusquedas(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ BÚSQUEDAS \n\n1)Habitaciones disponibles. \n2)Pacientes. \n3)Lista de doctores. \n\nElección:");
    }
    
    public void subMenuPacientes(){
        saltosDeLinea();
        System.out.println("\tSUBMENÚ BÚSQUEDAS \n\n1)Todos. \n2)Por piso. \n\nElección:");
    }
    
    public void saltosDeLinea(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
