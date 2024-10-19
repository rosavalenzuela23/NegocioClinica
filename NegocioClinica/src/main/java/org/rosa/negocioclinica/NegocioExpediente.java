/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOExpediente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import interfaces.INegocioExpediente;
import java.util.LinkedList;
import java.util.List;
import org.marcos.Entidades.Expediente;
import org.marcos.datosclinica.ExpedienteDAO;
import org.rosa.negocioclinica.util.GsonFactory;

/**
 *
 * @author
 */
public class NegocioExpediente implements INegocioExpediente {

    private final Gson parser;
    
    public NegocioExpediente() {
        super();
        parser = GsonFactory.createInstance();
    }
    
    private List<DTOExpediente> toDtoExpedientes(List<Expediente> expedientes) {
        
        List<DTOExpediente> dtoexpedientes = new LinkedList();
        
        for (var expediente : expedientes) {
            dtoexpedientes.add(DTOExpediente.from(expediente));
        }

        return dtoexpedientes;
    }

    @Override
    public String buscarExpedientes(Long idPsicologo) {

        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        List<Expediente> expedientes = expedienteDao.buscarExpedientesAbiertos(idPsicologo);
        
        String response = parser.toJson(toDtoExpedientes(expedientes));

        return response;
    }

    @Override
    public String registrarExpediente(String json) {
        Expediente expediente = parser.fromJson(json, Expediente.class);
        ExpedienteDAO expedienteDao = new ExpedienteDAO();

        return parser.toJson(expedienteDao.registrarExpediente(expediente));

    }

    @Override
    public String obtenerExpedientePorPacienteId(Long idPaciente) {
        var expedienteDao = new ExpedienteDAO();
        
        var expediente = expedienteDao.obtenerExpediente(idPaciente);
        
        return parser.toJson(DTOExpediente.from(expediente));
    }
    
}
