/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOExpediente;
import DTOEntidades.DTOPaciente;
import DTOEntidades.DTORegistroExpediente;
import DTOEntidades.DtoPacienteExpediente;
import com.google.gson.Gson;
import interfaces.INegocioExpediente;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.marcos.Entidades.Expediente;
import org.marcos.Entidades.IntegranteHogar;
import org.marcos.Entidades.Paciente;
import org.marcos.Entidades.Psicologo;
import org.marcos.datosclinica.ExpedienteDAO;
import org.marcos.datosclinica.PacienteDAO;
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
        DTORegistroExpediente registroExpediente = parser.fromJson(json, DTORegistroExpediente.class);

        var list = new ArrayList<Psicologo>();
        var listPaciente = new ArrayList<Paciente>();
        list.add(registroExpediente.getPsicologo());
        listPaciente.add(registroExpediente.getPaciente());

        Paciente paciente = registroExpediente.getPaciente();

        paciente.setPsicologos(list);

        paciente.setExpediente(registroExpediente.getExpediente());
        registroExpediente.getExpediente().setPaciente(paciente);
        registroExpediente.getPsicologo().setPacientes(listPaciente);

        var expediente = registroExpediente.getExpediente();

        if (expediente.getIntegranteHogar() != null) {
            for (var integranteHogar : registroExpediente.getExpediente().getIntegranteHogar()) {
                integranteHogar.setExpediente(registroExpediente.getExpediente());
            }
        }

        if (expediente.getFamiliaresConfianza() != null) {
            for (var familiarConfianza : registroExpediente.getExpediente().getFamiliaresConfianza()) {
                familiarConfianza.setExpediente(registroExpediente.getExpediente());
            }
        }

        PacienteDAO pacientedao = new PacienteDAO();

//        System.out.println(paciente.toString());
        pacientedao.guardar(paciente);

        return parser.toJson(DTOExpediente.from(paciente.getExpediente()));
    }

    @Override
    public String obtenerExpedientePorPacienteId(Long idPaciente) {
        var expedienteDao = new ExpedienteDAO();

        var expediente = expedienteDao.obtenerExpedientePorIdPaciente(idPaciente);

        return parser.toJson(DTOExpediente.from(expediente));
    }

    @Override
    public String actualizarExpediente(String json) {
        Gson g = GsonFactory.createInstance();
        
        var dtoexpedientePaciente = g.fromJson(json, DtoPacienteExpediente.class);
        
        var expedienteDao = new ExpedienteDAO();
        var pacienteDao = new PacienteDAO();
        
        expedienteDao.actualizarExpediente(dtoexpedientePaciente.getExpediente());
        pacienteDao.actualizarPaciente(dtoexpedientePaciente.getPaciente());
        
        return "{}";
    }

}
