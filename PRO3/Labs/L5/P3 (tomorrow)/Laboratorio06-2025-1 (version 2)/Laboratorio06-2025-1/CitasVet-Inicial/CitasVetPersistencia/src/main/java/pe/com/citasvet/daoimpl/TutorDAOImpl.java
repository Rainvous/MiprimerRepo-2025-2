package pe.com.citasvet.daoimpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.citasvet.dao.ITutorDAO;
import pe.com.citasvet.daoimpl.util.Columna;
import pe.com.citasvet.modelo.Tutor;

public class TutorDAOImpl extends BaseDAOImpl implements ITutorDAO {
    
    private Tutor tutor;
    
    public TutorDAOImpl() {
        super("tutor");
        this.tutor = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("dni", false, false));
        this.listaColumnas.add(new Columna("nombre", false, false));
        this.listaColumnas.add(new Columna("direccion", false, false));
        this.listaColumnas.add(new Columna("telefono", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.tutor.getDni());
        this.statement.setString(2, this.tutor.getNombre());
        this.statement.setString(3, this.tutor.getDireccion());
        this.statement.setString(4, this.tutor.getTelefono());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setString(1, this.tutor.getDni());
        this.statement.setString(2, this.tutor.getNombre());
        this.statement.setString(3, this.tutor.getDireccion());
        this.statement.setString(4, this.tutor.getTelefono());
        
        this.statement.setInt(5, this.tutor.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.tutor.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.tutor.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tutor = new Tutor();
        this.tutor.setId(this.resultSet.getInt("id"));
        this.tutor.setDni(this.resultSet.getString("dni"));
        this.tutor.setNombre(this.resultSet.getString("nombre"));
        this.tutor.setDireccion(this.resultSet.getString("direccion"));
        this.tutor.setTelefono(this.resultSet.getString("telefono"));
    } 
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tutor = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.tutor);
    }
    
    @Override
    public int insertar(Tutor tutor) {        
        try {
            this.tutor = tutor;
            return super.insertar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public Tutor buscar(int tutorId) {
        this.tutor = new Tutor();
        this.tutor.setId(tutorId);
        try {
            super.obtenerPorId();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.tutor;
    }
    
    @Override
    public ArrayList<Tutor> listar() {
        try {
            return (ArrayList<Tutor>) super.listarTodos();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean modificar(Tutor tutor) {
        this.tutor = tutor;
        try {
            return (super.modificar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean eliminar(int tutorId) {
        this.tutor = new Tutor();
        this.tutor.setId(tutorId);
        
        try {
            return (super.eliminar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}