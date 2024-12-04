/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
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
        
        RecepcionistaDAO rdao = new RecepcionistaDAO();
        String response = gson.toJson(rdao.registrarRecepcionista(nuevoRecepcionista));
        return response;
    }
    
}
