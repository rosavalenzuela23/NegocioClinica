/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;
import com.google.gson.Gson;
import interfaces.INegocioPsicologo;
import DTOEntidades.DTOEmpleadoLogIn;
import org.marcos.Entidades.Psicologo;
import org.marcos.datosclinica.PsicologoDAO;
/**
 *
 * @author 
 */
public class NegocioPsicologo implements INegocioPsicologo {

    @Override
    public String registrarPsicologo(String json) {
        
        Gson gson = new Gson();
        DTOEmpleadoLogIn dtoEmpleado =  gson.fromJson(json, DTOEmpleadoLogIn.class);
        
        Psicologo nuevoPsicologo = new Psicologo();
        nuevoPsicologo.setUsuario(dtoEmpleado.getUsuario());
        nuevoPsicologo.setContrasenia(dtoEmpleado.getPassword());
        
        PsicologoDAO pdao = new PsicologoDAO();
        String response = gson.toJson(pdao.registrarPsicologo(nuevoPsicologo));
        return response;
    }
    
}
