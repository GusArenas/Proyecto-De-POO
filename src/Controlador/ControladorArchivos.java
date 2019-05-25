/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modulo.Consultorio;
import Modulo.Doctor;
import Modulo.PacienteConsulta;
import Modulo.PacienteIngreso;
import Modulo.Personas;
import java.io.*;
import java.util.List;

/**
 *
 * @author Gusar
 */
public class ControladorArchivos {
    public void guardarDatosDoctor(Personas<Doctor> doctor){
        try{
            BufferedWriter printDoctor = new BufferedWriter(new FileWriter("DOCTOR.txt"));
            for(int i=0;i<doctor.obtenerCantidadDatos();i++){
                printDoctor.write("-----------------------------");
                printDoctor.newLine();
                printDoctor.write("----------Doctor: "+(i+1)+"----------");
                printDoctor.newLine();
                printDoctor.write("Id: "+String.valueOf(doctor.leerDatos(i).getId()));
                printDoctor.newLine();
                printDoctor.write("Nombre: "+doctor.leerDatos(i).getNombre());
                printDoctor.newLine();
                printDoctor.write("Especialidad: "+doctor.leerDatos(i).getEspecialidad());
                printDoctor.newLine();
                printDoctor.write("Correo: "+doctor.leerDatos(i).getCorreo());
                printDoctor.newLine();
                printDoctor.write("Telefono: "+String.valueOf(doctor.leerDatos(i).getTelefono()));
                printDoctor.newLine();
                printDoctor.write("Tarifa de consulta: "+String.valueOf(doctor.leerDatos(i).getTarifaDeConsulta()));
                printDoctor.newLine();
            }
            printDoctor.flush();
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
    }
    
    public void guardarDatosConsultorios(List<Consultorio> consultorios){
        try{
            BufferedWriter printConsultorios = new BufferedWriter(new FileWriter("CONSULTORIO.txt"));

            for(int i=0;i<50;i++){
                switch (i) {
                    case 0:
                        printConsultorios.write("----------Consultas Generales----------");
                        printConsultorios.newLine();
                        break;
                    case 10:
                        printConsultorios.write("-----------------------------");
                        printConsultorios.newLine();
                        printConsultorios.write("----------Cardiología----------");
                        printConsultorios.newLine();
                        break;
                    case 20:
                        printConsultorios.write("-----------------------------");
                        printConsultorios.newLine();
                        printConsultorios.write("----------Pediatría----------");
                        printConsultorios.newLine();
                        break;
                    case 30:
                        printConsultorios.write("-----------------------------");
                        printConsultorios.newLine();
                        printConsultorios.write("----------Urgencias----------");
                        printConsultorios.newLine();
                        break;
                    case 40:
                        printConsultorios.write("-----------------------------");
                        printConsultorios.newLine();
                        printConsultorios.write("----------Cirugía----------");
                        printConsultorios.newLine();
                        break;
                }
                if(consultorios.get(i).getIdDoctor()!=0){
                    printConsultorios.newLine();
                    printConsultorios.write("Id: "+String.valueOf(consultorios.get(i).getId()));
                    printConsultorios.newLine();
                    printConsultorios.write("Clave consultorio: "+String.valueOf(consultorios.get(i).getClaveConsultorio()));
                    printConsultorios.newLine();
                    printConsultorios.write("Id del doctor: "+String.valueOf(consultorios.get(i).getIdDoctor()));
                    printConsultorios.newLine();
                    printConsultorios.write("Id del paciente: "+String.valueOf(consultorios.get(i).getIdPaciente()));
                    printConsultorios.newLine();
                }
            }
            printConsultorios.flush();
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
    }
    
    public void guardarDatosPacienteConsulta(Personas<PacienteConsulta> pacienteConsulta)
    {   FileWriter FW= null;
        BufferedWriter BW=null;
        //String direccion="PACIENTECONSULTA.txt";
        try{
            File file= new File("PACIENTECONSULTA.txt");
            if(file.exists()==false)
            {
                file.createNewFile();
            }
            else{
    
            FW= new FileWriter(file.getAbsoluteFile(),true);
            BW=new BufferedWriter(FW);
           
            for(int i=0;i<pacienteConsulta.obtenerCantidadDatos();i++)
            {   BW.write(/*"Id: "+*/String.valueOf(pacienteConsulta.leerDatos(i).getId()));
                BW.newLine();
                BW.write(/*"Nombre: "+*/pacienteConsulta.leerDatos(i).getNombre());
                BW.newLine();
                BW.write(/*"# Seguro Social: "+*/String.valueOf(pacienteConsulta.leerDatos(i).getNumSeguroSocial()));
                BW.newLine();
                BW.write(/*"Correo: "+*/pacienteConsulta.leerDatos(i).getCorreo());
                BW.newLine();
                BW.write(/*"Telefono: "+*/String.valueOf(pacienteConsulta.leerDatos(i).getTelefono()));
                BW.newLine();
                BW.write(/*"Descripcion enfermedad: "+*/pacienteConsulta.leerDatos(i).getDescripcionDeEnfermedad());
                BW.newLine();
            }
            //informacion agregada
           // BW.flush();
           // BW.close();
            }
        }
        catch(IOException error){
            System.out.println(error.getMessage());
        }
        finally
        {   try
            {   if(BW!=null)
                   BW.close();
                if(FW!=null)
                   FW.close();
            }
            catch(IOException ex)
            {   ex.printStackTrace();
            }    
        }    
    }
    
    public void guardarDatosPacienteIngreso(Personas<PacienteIngreso> pacieteIngreso)
    {   FileWriter FW= null;
        BufferedWriter BW=null;
        try{
            File file= new File("PACIENTEINGRESO.txt");
            if (!file.exists())
            {
                file.createNewFile();
            }
            FW= new FileWriter(file.getAbsoluteFile(),true);
            BW= new BufferedWriter(FW);
            for(int i=0;i<pacieteIngreso.obtenerCantidadDatos();i++)
            {
                BW.write(String.valueOf(pacieteIngreso.leerDatos(i).getId()));
                BW.newLine();
                BW.write(pacieteIngreso.leerDatos(i).getNombre());
                BW.newLine();
                BW.write(String.valueOf(pacieteIngreso.leerDatos(i).getNumSeguroSocial()));
                BW.newLine();
                BW.write(pacieteIngreso.leerDatos(i).getCorreo());
                BW.newLine();
                BW.write(String.valueOf(pacieteIngreso.leerDatos(i).getTelefono()));
                BW.newLine();
                BW.write(pacieteIngreso.leerDatos(i).getDescripcionDeEnfermedad());
                BW.write(pacieteIngreso.leerDatos(i).getEnfermedad());
                BW.write(pacieteIngreso.leerDatos(i).getHabitacion());
                BW.newLine();
            }
            
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }
        finally
        {
            try
            {   if(BW!=null)
                    BW.close();
                if(FW!=null)
                    FW.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }    
        }    
        
    }        
    
}
