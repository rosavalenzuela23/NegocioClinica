/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
import DTOEntidades.DTOEmpleado;
import DTOEntidades.DTOEmpleadoLogIn;
import com.google.gson.Gson;
import interfaces.INegocioAdministrador;
import org.marcos.Entidades.Administrador;
import org.marcos.datosclinica.AdministradorDAO;
/**
 *
 * @author 
 */
public class NegocioAdministrador implements INegocioAdministrador{

    @Override
    public String registrarAdministrador(String json) {
       Gson gson = new Gson();
        DTOEmpleadoLogIn dtoEmpleado =  gson.fromJson(json, DTOEmpleadoLogIn.class);
        
        Administrador nuevoAdministrador = new Administrador();
        nuevoAdministrador.setUsuario(dtoEmpleado.getUsuario());
        nuevoAdministrador.setContrasenia(dtoEmpleado.getPassword());
        nuevoAdministrador.setEstado(true);
        
        AdministradorDAO adao = new AdministradorDAO();
        String response = gson.toJson(adao.registrarAdministrador(nuevoAdministrador));
        return response;
    }

    @Override
    public String actualizarAdministrador(String json) {
         Gson gson = new Gson();
        
        DTOEmpleado empleadoActualizado = gson.fromJson(json, DTOEmpleado.class);
        
        Administrador administradorActualizado = new Administrador();
        administradorActualizado.setId(empleadoActualizado.getId());
        administradorActualizado.setUsuario(empleadoActualizado.getUsuario());
        administradorActualizado.setContrasenia(empleadoActualizado.getPassword());
        administradorActualizado.setEstado(true);
        
        AdministradorDAO adao = new AdministradorDAO();
        String response = gson.toJson(adao.actualizarAdministrador(administradorActualizado));
        return response;
    }
    
    
}
