/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author natsu
 */
public interface INegocioPaciente {
    
    public String buscarPacienteSiguiente();
    public String getPacientesPsicologo(Long id);
    public void agregarCartaConcentimiento(String paciente, byte[] carta);
    public String obtenerPacientesSinCarta();
    public String obtenerTodos();
}
