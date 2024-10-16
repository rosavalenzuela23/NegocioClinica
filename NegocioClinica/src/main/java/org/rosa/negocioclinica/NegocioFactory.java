/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica;

import interfaces.INegocio;

/**
 *
 * @author natsu
 */
public class NegocioFactory {
    
    public static INegocio createInstance() {
        return new Negocio();
    }
    
}
