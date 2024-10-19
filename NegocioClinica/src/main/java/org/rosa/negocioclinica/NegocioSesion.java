/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import DTOEntidades.DTOSesion;
import com.google.gson.Gson;
import interfaces.INegocioSesion;
import org.marcos.Entidades.ComentarioSesion;
import org.marcos.Entidades.Problema;
import org.marcos.Entidades.Sesion;
import org.marcos.datosclinica.SesionDAO;

/**
 *
 * @author 
 */
public class NegocioSesion implements INegocioSesion{

    @Override
    public String registrarSesion(String json) {
        Gson gson = new Gson();
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
