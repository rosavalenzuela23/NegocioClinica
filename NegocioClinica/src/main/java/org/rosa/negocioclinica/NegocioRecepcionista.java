/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
import DTOEntidades.DTOEmpleado;
import DTOEntidades.DTOEmpleadoLogIn;
import com.google.gson.Gson;
import interfaces.INegocioRecepcionista;
import org.marcos.Entidades.Recepcionista;
import org.marcos.datosclinica.RecepcionistaDAO;
/**
 *
 * @author 
 */
public class NegocioRecepcionista implements INegocioRecepcionista{

    @Override
    public String registrarRecepcionista(String json) {
        Gson gson = new Gson();
        DTOEmpleadoLogIn dtoEmpleado =  gson.fromJson(json, DTOEmpleadoLogIn.class);
        
        Recepcionista nuevoRecepcionista = new Recepcionista();
        nuevoRecepcionista.setUsuario(dtoEmpleado.getUsuario());
        nuevoRecepcionista.setContrasenia(dtoEmpleado.getPassword());
        nuevoRecepcionista.setEstado(true);
        
        RecepcionistaDAO rdao = new RecepcionistaDAO();
        String response = gson.toJson(rdao.registrarRecepcionista(nuevoRecepcionista));
        return response;
    }

    @Override
    public String actualizarRecepcionista(String json) {
         Gson gson = new Gson();
        
        DTOEmpleado empleadoActualizado = gson.fromJson(json, DTOEmpleado.class);
        
        Recepcionista recepcionistaActualizado = new Recepcionista();
        recepcionistaActualizado.setId(empleadoActualizado.getId());
        recepcionistaActualizado.setUsuario(empleadoActualizado.getUsuario());
        recepcionistaActualizado.setContrasenia(empleadoActualizado.getPassword());
        recepcionistaActualizado.setEstado(true);
        
        RecepcionistaDAO rdao = new RecepcionistaDAO();
        String response = gson.toJson(rdao.actualizarRecepcionista(recepcionistaActualizado));
        return response;
    }
    
}
