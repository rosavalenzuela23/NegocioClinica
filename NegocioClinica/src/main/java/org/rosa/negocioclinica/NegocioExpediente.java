/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import com.google.gson.Gson;
import interfaces.INegocioExpediente;
import java.util.List;
import org.marcos.Entidades.Expediente;
import org.marcos.Entidades.Paciente;
import org.marcos.datosclinica.ExpedienteDAO;
import org.marcos.datosclinica.PacienteDAO;
/**
 * 
 * @author 
 */
public class NegocioExpediente implements INegocioExpediente {

    @Override
    public String buscarExpedientes(Long idPsicologo) {
        
        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        List<Expediente> expedientes = expedienteDao.buscarExpedientesAbiertos(idPsicologo);
        
        Gson gson = new Gson();
        String response = gson.toJson(expedientes);
        
        return response;
    }

    @Override
    public String registrarExpediente(String json) {
        
        Gson gson = new Gson();
        Expediente expediente = gson.fromJson(json, Expediente.class);
        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        
        return gson.toJson(expedienteDao.registrarExpediente(expediente));
        
    }
    
}

