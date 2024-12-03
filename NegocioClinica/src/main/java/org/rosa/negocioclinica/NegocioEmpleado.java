/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
import com.google.gson.Gson;
import interfaces.INegocioEmpleado;
import org.marcos.datosclinica.EmpleadoDAO;
import DTOEntidades.DTOEmpleadoLogIn;
import DTOEntidades.DTOEmpleado;
import org.marcos.Entidades.Empleado;

/**
 *
 * @author 
 */
public class NegocioEmpleado implements INegocioEmpleado{

    @Override
    public String obtenerEmpleado(String json)throws Exception {
        try{
            
            EmpleadoDAO empdao = new EmpleadoDAO();
            Gson gson = new Gson();
            DTOEmpleadoLogIn emp = gson.fromJson(json, DTOEmpleadoLogIn.class);
            Empleado empleado = empdao.obtenerEmpleado(emp.getUsuario(), emp.getPassword());
            System.out.println("El empleado es de tipo.... " + empleado.getClass().getSimpleName());
            String response = gson.toJson(DTOEmpleado.from(empleado));
            return response;
          
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        
    }
    
}
