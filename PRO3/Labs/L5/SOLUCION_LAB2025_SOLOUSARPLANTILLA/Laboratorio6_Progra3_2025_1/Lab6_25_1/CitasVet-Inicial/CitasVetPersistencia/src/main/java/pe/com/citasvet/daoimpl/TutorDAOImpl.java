package pe.com.citasvet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.com.citasvet.config.DBManager;
import pe.com.citasvet.dao.ITutorDAO;
import pe.com.citasvet.daobase.DAOImplBase;
import pe.com.citasvet.daobase.utils.Columna;
import pe.com.citasvet.modelo.Paciente;
import pe.com.citasvet.modelo.Tutor;

public class TutorDAOImpl extends DAOImplBase implements ITutorDAO {

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
    public int insertar(Tutor tutor) {
        this.tutor = tutor;
        System.out.println("Insertanto en tutor....");
        return super.insertar();
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, tutor.getDni());
        this.statement.setString(2, tutor.getNombre());
        this.statement.setString(3, tutor.getDireccion());
        this.statement.setString(4, tutor.getTelefono());
        System.out.println("SQL: " + statement);

    }

    @Override
    public boolean modificar(Tutor tutor) {
        this.tutor = tutor;
        return super.modificar() != 0 ? true : false;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, tutor.getDni());
        this.statement.setString(2, tutor.getNombre());
        this.statement.setString(3, tutor.getDireccion());
        this.statement.setString(4, tutor.getTelefono());
        //buscar dni
        this.statement.setInt(5, tutor.getId());
    }

    @Override
    public boolean eliminar(int id) {
        this.tutor = new Tutor();
        this.tutor.setId(id);
        return super.eliminar() != 0 ? true : false;

    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.tutor.getId());
    }

    @Override
    public Tutor buscar(int id) {
        this.tutor = new Tutor();
        tutor.setId(id);
        super.obtenerPorId();
        return this.tutor;
    }
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException{
        this.statement.setInt(1, tutor.getId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tutor = new Tutor();
        tutor.setId(this.resultSet.getInt("id"));
        this.tutor.setDni(this.resultSet.getString("dni"));
        this.tutor.setNombre(this.resultSet.getString("nombre"));
        this.tutor.setDireccion(this.resultSet.getString("direccion"));
        this.tutor.setTelefono(this.resultSet.getString("telefono"));

    }
//            this.listaColumnas.add(new Columna("id", true, true));
//        this.listaColumnas.add(new Columna("dni", false, false));
//        this.listaColumnas.add(new Columna("nombre", false, false));
//        this.listaColumnas.add(new Columna("direccion", false, false));
//        this.listaColumnas.add(new Columna("telefono", false, false));
    @Override
    protected void limpiarObjetoDelResultSet(){
        this.tutor=null;
        
    }

    @Override
    public List<Tutor> listar() {
        return (List<Tutor>) super.listarTodos();
        //NOTA: El list<tutor> es como si hicieras esto int a= (double) (3.5/2); 

    }
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.tutor);
    }

}
