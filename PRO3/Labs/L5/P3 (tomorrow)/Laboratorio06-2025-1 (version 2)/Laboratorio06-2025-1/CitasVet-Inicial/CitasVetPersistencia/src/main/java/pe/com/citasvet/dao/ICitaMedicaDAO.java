package pe.com.citasvet.dao;

import java.util.List;
import pe.com.citasvet.modelo.CitaMedica;

/**
 *
 * @author ferro
 */
public interface ICitaMedicaDAO extends ICrud<CitaMedica> {
    
    // De la Pregunta 3
    List<CitaMedica> listarPorPaciente(int pacienteId);
}
