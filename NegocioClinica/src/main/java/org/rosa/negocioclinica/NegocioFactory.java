/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import interfaces.INegocioExpediente;
import interfaces.INegocioSesion;
import interfaces.INegocioPaciente;

/**
 *
 * @author natsu
 */
public class NegocioFactory {
    
    public static INegocioPaciente createInstancePaciente() {
        return new NegocioPaciente();
    }
    
    public static INegocioExpediente createInstanceExpediente(){
        return new NegocioExpediente();
    }
    
    public static INegocioSesion createInstanceSesion(){
        return new NegocioSesion();
    }
    
}

