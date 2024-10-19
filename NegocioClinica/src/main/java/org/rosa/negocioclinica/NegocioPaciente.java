/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOPaciente;
import com.google.gson.Gson;
import interfaces.INegocioPaciente;
import java.util.LinkedList;
import java.util.List;
import org.marcos.Entidades.Paciente;
import org.marcos.datosclinica.PacienteDAO;
import org.rosa.negocioclinica.util.GsonFactory;

/**
 *
 * @author natsu
 */
public class NegocioPaciente implements INegocioPaciente {

    private final Gson gson;
    
    public NegocioPaciente() {
        super();
        this.gson = GsonFactory.createInstance();
    }
    
    private List<DTOPaciente> listToDto(List<Paciente> pacientes) {
        var list = new LinkedList<DTOPaciente>();
        for (Paciente p : pacientes) {
            list.add(DTOPaciente.from(p));
        }
        return list;
    }
    
    @Override
    public String buscarPacienteSiguiente() {
        return "{rosa: 1}";
    }

    @Override
    public String getPacientesPsicologo(Long id) {

        var pacienteDao = new PacienteDAO();
        List<Paciente> pacientes = pacienteDao.obtenerPacientesDelPsicologo(id);
        
        return gson.toJson(listToDto(pacientes));
    }
    
    
}
