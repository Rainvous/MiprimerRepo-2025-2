/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.citasvet.daoimpl;

import java.sql.Date;
import static java.sql.JDBCType.DATE;
import java.sql.SQLException;
import static java.sql.Types.DATE;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.citasvet.dao.ICitaMedicaDAO;
import pe.com.citasvet.daobase.DAOImplBase;
import pe.com.citasvet.daobase.utils.Columna;
import pe.com.citasvet.modelo.CitaMedica;
import pe.com.citasvet.modelo.Medico;
import pe.com.citasvet.modelo.Paciente;

/**
 *
 * @author User
 */
public class CitaMedicaDAOImpl extends DAOImplBase implements ICitaMedicaDAO {

    private CitaMedica citamedica;

    public CitaMedicaDAOImpl() {
        super("citamedica");
        this.citamedica = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ID", true, true));
        this.listaColumnas.add(new Columna("IdPaciente", false, false));
        this.listaColumnas.add(new Columna("IdMedico", false, false));
        this.listaColumnas.add(new Columna("motivo", false, false));
        this.listaColumnas.add(new Columna("fecha", false, false));

    }

    protected void incluirValorDeParametrosParaInsercion() {
        try {
            this.statement.setInt(1, citamedica.getPaciente().getId());
            this.statement.setInt(2, citamedica.getMedico().getId());
            this.statement.setString(3, citamedica.getMotivo());
            this.statement.setDate(4, (Date) citamedica.getFecha());
        } catch (SQLException ex) {
            System.err.println("No subio el statement");
            Logger.getLogger(CitaMedicaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int insertar(CitaMedica citamedica) {
        this.citamedica = citamedica;
        return super.insertar();

    }

    @Override
    public boolean modificar(CitaMedica citaMedica) {
        this.citamedica = citaMedica;
        return super.modificar() != 0 ? true : false;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
//todos los dato
        this.statement.setInt(1, citamedica.getPaciente().getId());
        this.statement.setInt(2, citamedica.getMedico().getId());
        this.statement.setString(3, citamedica.getMotivo());
        this.statement.setDate(4, (Date) citamedica.getFecha());
//            this.listaColumnas.add(new Columna("motivo", false, false));
//        this.listaColumnas.add(new Columna("fecha", false, false));

        //buscar que id 
        this.statement.setInt(5, citamedica.getId());
    }

    @Override
    public boolean eliminar(int id) {
        this.citamedica = new CitaMedica();
        this.citamedica.setId(id);
        return super.eliminar() != 0 ? true : false;
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.citamedica.getId());
    }

    @Override
    public CitaMedica buscar(int id) {
        this.citamedica = new CitaMedica();
        citamedica.setId(id);
        super.obtenerPorId();
        return this.citamedica;

    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.citamedica.getId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.citamedica = new CitaMedica();
        citamedica.setId(this.resultSet.getInt("ID"));
        Medico medic = new Medico(); //clase que dentro de la clase paciente
        medic.setId(this.resultSet.getInt("IdMedico"));
        this.citamedica.setMedico(medic);//fin de la configuracion de 
        //la clase aparte
        Paciente paciente = new Paciente();
        paciente.setId(this.resultSet.getInt("IdPaciente"));

        this.citamedica.setMotivo(this.resultSet.getString("motivo"));
        java.sql.Date sqldate = this.resultSet.getDate("fecha");

        this.citamedica.setFecha(new java.util.Date(sqldate.getTime()));

//        
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.citamedica = null;
    }

    @Override
    public List<CitaMedica> listar() {
        return (List<CitaMedica>) super.listarTodos();
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.citamedica);
    }

}
