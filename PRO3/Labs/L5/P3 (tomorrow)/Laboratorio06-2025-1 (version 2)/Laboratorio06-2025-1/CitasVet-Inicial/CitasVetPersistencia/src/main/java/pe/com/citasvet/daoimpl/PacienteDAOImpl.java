package pe.com.citasvet.daoimpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.citasvet.dao.IPacienteDAO;
import pe.com.citasvet.daoimpl.util.Columna;
import pe.com.citasvet.modelo.Paciente;
import pe.com.citasvet.modelo.Tutor;

public class PacienteDAOImpl extends BaseDAOImpl implements IPacienteDAO {
    
    private Paciente paciente;
    
    public PacienteDAOImpl() {
        super("paciente");
        this.paciente = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("idTutor", false, false));
        this.listaColumnas.add(new Columna("nombre", false, false));
        this.listaColumnas.add(new Columna("especie", false, false));
        this.listaColumnas.add(new Columna("raza", false, false));
        this.listaColumnas.add(new Columna("edad", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.paciente.getTutor().getId());
        this.statement.setString(2, this.paciente.getNombre());
        this.statement.setString(3, this.paciente.getEspecie());
        this.statement.setString(4, this.paciente.getRaza());
        this.statement.setInt(5, this.paciente.getEdad());
        this.statement.setString(6, this.paciente.getEstado());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setInt(1, this.paciente.getTutor().getId());
        this.statement.setString(2, this.paciente.getNombre());
        this.statement.setString(3, this.paciente.getEspecie());
        this.statement.setString(4, this.paciente.getRaza());
        this.statement.setInt(5, this.paciente.getEdad());
        this.statement.setString(6, this.paciente.getEstado());
        
        this.statement.setInt(7, this.paciente.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.paciente.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.paciente.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.paciente = new Paciente();
        this.paciente.setId(this.resultSet.getInt("id"));
        this.paciente.setTutor((Tutor) new TutorDAOImpl().buscar(this.resultSet.getInt("idTutor")));
        this.paciente.setNombre(this.resultSet.getString("nombre"));
        this.paciente.setEspecie(this.resultSet.getString("especie"));
        this.paciente.setRaza(this.resultSet.getString("raza"));
        this.paciente.setEdad(this.resultSet.getInt("edad"));
        this.paciente.setEstado(this.resultSet.getString("estado"));
    } 
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.paciente = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.paciente);
    }
    
    @Override
    public int insertar(Paciente paciente) {        
        this.paciente = paciente;
        try {
            return super.insertar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public Paciente buscar(int pacienteId) {
        this.paciente = new Paciente();
        this.paciente.setId(pacienteId);
        try {
            super.obtenerPorId();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.paciente;
    }
    
    @Override
    public ArrayList<Paciente> listar() {
        try {
            return (ArrayList<Paciente>) super.listarTodos();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean modificar(Paciente paciente) {
        this.paciente = paciente;
        try {
            return (super.modificar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean eliminar(int pacienteId) {
        this.paciente = new Paciente();
        this.paciente.setId(pacienteId);
        
        try {
            return (super.eliminar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
