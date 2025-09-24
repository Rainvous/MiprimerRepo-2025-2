package pe.com.citasvet.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.com.citasvet.config.DBManager;
import pe.com.citasvet.dao.IPacienteDAO;
import pe.com.citasvet.daobase.DAOImplBase;
import pe.com.citasvet.daobase.utils.Columna;
import pe.com.citasvet.modelo.Paciente;
import pe.com.citasvet.modelo.Tutor;

public class PacienteDAOImpl extends DAOImplBase implements IPacienteDAO {

    private Paciente paciente;

    public PacienteDAOImpl() {
        super("paciente");
        this.paciente = null;
        this.retornarLlavePrimaria = true;
    }

//        protected String nombre_tabla;
//    protected ArrayList<Columna> listaColumnas;
//    protected Boolean retornarLlavePrimaria;
//    protected Connection conexion;
//    protected CallableStatement statement;
//    protected ResultSet resultSet;
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ID", true, true));
        this.listaColumnas.add(new Columna("IdTutor", false, false));
        this.listaColumnas.add(new Columna("nombre", false, false));
        this.listaColumnas.add(new Columna("especie", false, false));
        this.listaColumnas.add(new Columna("raza", false, false));
        this.listaColumnas.add(new Columna("edad", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));

    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        System.out.println("-> " + paciente.getTutor().getId() + " -> " + paciente.getNombre());
        this.statement.setInt(1, paciente.getTutor().getId());
        this.statement.setString(2, paciente.getNombre());
        this.statement.setString(3, paciente.getEspecie());
        this.statement.setString(4, paciente.getRaza());
        this.statement.setInt(5, paciente.getEdad());
        this.statement.setString(6, paciente.getEstado());
        System.out.println(statement);
        System.out.println("HOLA entre a la inserccion");
    }

    @Override
    public int insertar(Paciente paciente) {
        this.paciente = paciente;
        return super.insertar();
        //PARA INSERCION DEBES CREAR Este metodo sobreescrito
        //protected void incluirValorDeParametrosParaInsercion()

    }

    @Override
    public boolean modificar(Paciente paciente) {

        this.paciente = paciente;
        return super.modificar() != 0 ? true : false;

        //para modificar debes crear esto ->  protected void incluirValorDeParametrosParaModificacion()
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        //todos los dato
        this.statement.setInt(1, paciente.getTutor().getId());
        this.statement.setString(2, paciente.getNombre());
        this.statement.setString(3, paciente.getEspecie());
        this.statement.setString(4, paciente.getRaza());
        this.statement.setInt(5, paciente.getEdad());
        this.statement.setString(6, paciente.getEstado());
        //buscar que id 
        this.statement.setInt(7, paciente.getId());
    }

    public boolean eliminar(int id) {

       
        this.paciente= new Paciente();
       
        this.paciente.setId(id);
        
        Integer resultado= super.eliminar() ;
        return  resultado!=0? true:false;
        // para eliminar debes sobreescribi ese metodo
        // protected void incluirValorDeParametrosParaEliminacion() 
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.paciente.getId());
    }

    @Override
    public Paciente buscar(int id) {

        this.paciente = new Paciente();
        paciente.setId(id);
        super.obtenerPorId(); //AL MOMENTO DE OBTENER POR ID DEBES SOBREESCRIBIR
        //el metodo instanciar objeto dell result set e limpiar objeto del result set//
        //    protected void instanciarObjetoDelResultSet()      protected void limpiarObjetoDelResultSet() 
        // incluirValorDeParametrosParaObtenerPorId()
        return this.paciente;

    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.paciente = new Paciente();
        paciente.setId(this.resultSet.getInt("ID"));
        Tutor tuto= new Tutor(); //clase que dentro de la clase paciente
        tuto.setId(this.resultSet.getInt("IdTutor"));
        this.paciente.setTutor(tuto);//fin de la configuracion de 
        //la clase aparte
        
        this.paciente.setNombre(this.resultSet.getString("nombre"));
        this.paciente.setEspecie(this.resultSet.getString("especie"));
        this.paciente.setRaza(this.resultSet.getString("raza"));
        this.paciente.setEdad(this.resultSet.getInt("edad"));
        this.paciente.setEstado(this.resultSet.getString("estado"));
//        

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.paciente = null;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.paciente.getId());
    }

    @Override
    public List<Paciente> listar() {
        return (List<Paciente>) super.listarTodos();
        //AL MOMENTO DE HACER ESTO TIENES QUE LLAMAR A LOS SIGUIENTES METODOS
        // agregarObjetoALaLista(List lista) 
        //sobreecribir este objeto -> .instanciarObjetoDelResultSet();
        //protected void agregarObjetoALaLista(List lista)

    }
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.paciente);
    }

}
