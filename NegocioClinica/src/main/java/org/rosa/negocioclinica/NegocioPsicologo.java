/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
import com.google.gson.Gson;
import interfaces.INegocioPsicologo;
import DTOEntidades.DTOEmpleadoLogIn;
import DTOEntidades.DTOEmpleado;
import org.marcos.Entidades.Empleado;
import org.marcos.Entidades.Psicologo;
import org.marcos.datosclinica.PsicologoDAO;
/**
 *
 * @author 
 */
public class NegocioPsicologo implements INegocioPsicologo {

    @Override
    public String registrarPsicologo(String json) {
        
        Gson gson = new Gson();
        DTOEmpleadoLogIn dtoEmpleado =  gson.fromJson(json, DTOEmpleadoLogIn.class);
        
        Psicologo nuevoPsicologo = new Psicologo();
        nuevoPsicologo.setUsuario(dtoEmpleado.getUsuario());
        nuevoPsicologo.setContrasenia(dtoEmpleado.getPassword());
        nuevoPsicologo.setEstado(true);
        
        PsicologoDAO pdao = new PsicologoDAO();
        String response = gson.toJson(pdao.registrarPsicologo(nuevoPsicologo));
        return response;
    }

    @Override
    public String actualizarPsicologo(String json) {
        Gson gson = new Gson();
        
        DTOEmpleado empleadoActualizado = gson.fromJson(json, DTOEmpleado.class);
        
        Psicologo psicologoActualizado = new Psicologo();
        psicologoActualizado.setId(empleadoActualizado.getId());
        psicologoActualizado.setUsuario(empleadoActualizado.getUsuario());
        psicologoActualizado.setContrasenia(empleadoActualizado.getPassword());
        psicologoActualizado.setEstado(true);
        
        PsicologoDAO pdao = new PsicologoDAO();
        String response = gson.toJson(pdao.actualizarPsicologo(psicologoActualizado));
        return response;
    }
    
}
