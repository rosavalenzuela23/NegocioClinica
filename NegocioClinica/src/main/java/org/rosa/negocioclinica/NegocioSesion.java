/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import com.google.gson.Gson;
import interfaces.INegocioSesion;
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
        SesionDAO sesionDao = new SesionDAO();
        
        return gson.toJson(sesionDao.agregarSesion(sesion));
    }
    
}
