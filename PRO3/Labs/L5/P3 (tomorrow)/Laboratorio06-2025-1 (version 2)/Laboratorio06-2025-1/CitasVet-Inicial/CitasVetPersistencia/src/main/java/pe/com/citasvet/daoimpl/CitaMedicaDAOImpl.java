package pe.com.citasvet.daoimpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.citasvet.dao.ICitaMedicaDAO;
import pe.com.citasvet.daoimpl.util.Columna;
import pe.com.citasvet.modelo.CitaMedica;

/**
 *
 * @author ferro
 */
public class CitaMedicaDAOImpl extends BaseDAOImpl implements ICitaMedicaDAO {

    private CitaMedica cita;

    public CitaMedicaDAOImpl() {
        super("citamedica");
        this.cita = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id", true, true));
        this.listaColumnas.add(new Columna("idPaciente", false, false));
        this.listaColumnas.add(new Columna("idMedico", false, false));
        this.listaColumnas.add(new Columna("motivo", false, false));
        this.listaColumnas.add(new Columna("fecha", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.cita.getPaciente().getId());
        this.statement.setInt(2, this.cita.getMedico().getId());
        this.statement.setString(3, this.cita.getMotivo());
        // this.statement.setDate(4, (Date) this.cita.getFecha());
        java.util.Date fecha = this.cita.getFecha();        // util.Date
        this.statement.setDate(4, new java.sql.Date(fecha.getTime()));  // SQL Date
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.cita.getPaciente().getId());
        this.statement.setInt(2, this.cita.getMedico().getId());
        this.statement.setString(3, this.cita.getMotivo());
        // this.statement.setDate(4, (Date) this.cita.getFecha());
        java.util.Date fecha = this.cita.getFecha();        // util.Date
        this.statement.setDate(4, new java.sql.Date(fecha.getTime()));  // SQL Date

        this.statement.setInt(5, this.cita.getId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.cita.getId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.cita.getId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cita = new CitaMedica();
        this.cita.setId(this.resultSet.getInt("id"));
        this.cita.setPaciente(new PacienteDAOImpl().buscar(this.resultSet.getInt("idPaciente")));
        this.cita.setMedico(new MedicoDAOImpl().buscar(this.resultSet.getInt("idMedico")));
        this.cita.setMotivo(this.resultSet.getString("motivo"));
        // this.cita.setFecha(this.resultSet.getDate("fecha"));
        java.sql.Date sqlDate = this.resultSet.getDate("fecha");
        this.cita.setFecha(new java.util.Date(sqlDate.getTime()));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.cita);
    }

    @Override
    public int insertar(CitaMedica cita) {
        try {
            this.cita = cita;
            return super.insertar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public CitaMedica buscar(int citaId) {
        this.cita = new CitaMedica();
        this.cita.setId(citaId);
        try {
            super.obtenerPorId();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.cita;
    }

    @Override
    public ArrayList<CitaMedica> listar() {
        try {
            return (ArrayList<CitaMedica>) super.listarTodos();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean modificar(CitaMedica cita) {
        this.cita = cita;
        try {
            return (super.modificar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int citaId) {
        this.cita = new CitaMedica();
        this.cita.setId(citaId);

        try {
            return (super.eliminar() > 0);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<CitaMedica> listarPorPaciente(int pacienteId) {

        String sql = this.generarSQLParaListarPorPaciente();
        try {
            return (ArrayList<CitaMedica>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorPaciente, pacienteId);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String generarSQLParaListarPorPaciente() {

        String sql = "SELECT * ";
        sql = sql.concat("FROM citamedica ");
        sql = sql.concat("WHERE idPaciente = ?");

        return sql;
    }

    private void incluirValorDeParametrosParaListarPorPaciente(Object objetoParametros) {

        try {
            this.statement.setInt(1, (int) objetoParametros);
        } catch (SQLException ex) {
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
