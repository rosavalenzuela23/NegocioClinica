/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author 
 */
public interface INegocioExpediente {
     public String buscarExpedientes(Long idPsicologo);
     public String registrarExpediente(String json);
    
}