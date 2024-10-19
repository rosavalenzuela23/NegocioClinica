/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOSesion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import interfaces.INegocioSesion;
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
    
}
