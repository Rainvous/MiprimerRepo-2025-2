package pe.com.citasvet.daoimpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.citasvet.dao.IMedicoDAO;
import pe.com.citasvet.daoimpl.util.Columna;
import pe.com.citasvet.modelo.Medico;

public class MedicoDAOImpl extends BaseDAOImpl implements IMedicoDAO {

    private Medico medico;
    
    public MedicoDAOImpl() {
        super("medico");
        this.medico = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("dni", false, false));
        this.listaColumnas.add(new Columna("nombre", false, false));
        this.listaColumnas.add(new Columna("especialidad", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.medico.getDni());
        this.statement.setString(2, this.medico.getNombre());
        this.statement.setString(3, this.medico.getEspecialidad());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {        
        this.statement.setString(1, this.medico.getDni());
        this.statement.setString(2, this.medico.getNombre());
        this.statement.setString(3, this.medico.getEspecialidad());
        
        this.statement.setInt(4, this.medico.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.medico.getId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.medico.getId());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.medico = new Medico();
        this.medico.setId(this.resultSet.getInt("id"));
        this.medico.setDni(this.resultSet.getString("dni"));
        this.medico.setNombre(this.resultSet.getString("nombre"));
        this.medico.setEspecialidad(this.resultSet.getString("especialidad"));
    } 
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.medico = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.medico);
    }
    
    @Override
    public int insertar(Medico medico) {        
        try {
            this.medico = medico;
            return super.insertar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public Medico buscar(int medicoId) {
        this.medico = new Medico();
        this.medico.setId(medicoId);
        try {
            super.obtenerPorId();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.medico;
    }
    
    @Override
    public ArrayList<Medico> listar() {
        try {
            return (ArrayList<Medico>) super.listarTodos();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean modificar(Medico medico) {
        this.medico = medico;
        try {
            return (super.modificar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean eliminar(int medicoId) {
        this.medico = new Medico();
        this.medico.setId(medicoId);
        
        try {
            return (super.eliminar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MedicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}