/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author 
 */
public interface INegocioEmpleado {
    public String obtenerEmpleado(String json)throws Exception;
    public String obtenerEmpleados();
    public String eliminarEmpleado(String json);
}
