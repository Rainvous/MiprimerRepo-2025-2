package pe.com.citasvet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.com.citasvet.config.DBManager;
import pe.com.citasvet.dao.IMedicoDAO;
import pe.com.citasvet.daobase.DAOImplBase;
import pe.com.citasvet.daobase.utils.Columna;
import pe.com.citasvet.modelo.Medico;

public class MedicoDAOImpl extends DAOImplBase implements IMedicoDAO {

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
    public int insertar(Medico medico) {
        this.medico = medico;
        return super.insertar();

    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, medico.getDni());
        this.statement.setString(2, medico.getNombre());
        this.statement.setString(3, medico.getEspecialidad());

        System.out.println("SQL: " + statement);

    }

    @Override
    public boolean modificar(Medico medico) {
        this.medico = medico;
        return super.modificar() != 0 ? true : false;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, medico.getDni());
        this.statement.setString(2, medico.getNombre());
        this.statement.setString(3, medico.getEspecialidad());
        //buscar dni
        this.statement.setInt(4, medico.getId());
    }

    @Override
    public boolean eliminar(int id) {
        this.medico = new Medico();
        medico.setId(id);
        return super.eliminar() != 0 ? true : false;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.medico.getId());

    }

    @Override
    public Medico buscar(int id) {
        this.medico = new Medico();
        medico.setId(id);
        super.obtenerPorId();
        return this.medico;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, medico.getId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.medico = new Medico();
        medico.setId(this.resultSet.getInt("id"));
        this.medico.setDni(this.resultSet.getString("dni"));
        this.medico.setNombre(this.resultSet.getString("nombre"));
        this.medico.setEspecialidad(this.resultSet.getString("especialidad"));

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.medico = null;

    }

    @Override
    public List<Medico> listar() {
        return (List<Medico>) super.listarTodos();

    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.medico);
    }

}
