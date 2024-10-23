/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOSesion;
import com.google.gson.Gson;
import interfaces.INegocioSesion;
import java.util.LinkedList;
import java.util.List;
import org.marcos.Entidades.ComentarioSesion;
import org.marcos.Entidades.Problema;
import org.marcos.Entidades.Sesion;
import org.marcos.datosclinica.SesionDAO;
import org.rosa.negocioclinica.util.GsonFactory;

/**
 *
 * @author 
 */
public class NegocioSesion implements INegocioSesion{

    private final Gson gson;
    
    public NegocioSesion() {
        super();
        this.gson = GsonFactory.createInstance();
    }
    
    private List<DTOSesion> listToDto(List<Sesion> sesiones) {
        var list = new LinkedList<DTOSesion>();
        for (Sesion s : sesiones) {
            list.add(DTOSesion.from(s));
        }
        return list;
    }
    
    @Override
    public String registrarSesion(String json) {
        
        Sesion sesion = gson.fromJson(json, Sesion.class);
        
        for (ComentarioSesion comentario : sesion.getComentarios()) {
            comentario.setSesion(sesion);
        }
        
        for (Problema problema : sesion.getProblemasSesion()) {
            problema.setSesion(sesion);
        }
        
        SesionDAO sesionDao = new SesionDAO();
        Sesion response = sesionDao.agregarSesion(sesion);
        DTOSesion dtoResponse =  DTOSesion.from(response);
        return gson.toJson(dtoResponse);
    }
    
    @Override
    public String obtenerSesionesExpediente(Long expedienteId){
        
        var sesionDao = new SesionDAO();
        List<Sesion> sesiones =  sesionDao.obtenerSesiones(expedienteId);
        return gson.toJson(listToDto(sesiones));
    }
}
