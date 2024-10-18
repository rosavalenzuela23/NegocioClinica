/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOExpediente;
import com.google.gson.Gson;
import interfaces.INegocioExpediente;
import java.util.LinkedList;
import java.util.List;
import org.marcos.Entidades.Expediente;
import org.marcos.datosclinica.ExpedienteDAO;

/**
 *
 * @author
 */
public class NegocioExpediente implements INegocioExpediente {

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
        
        Gson gson = new Gson();
        String response = gson.toJson(toDtoExpedientes(expedientes));

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
