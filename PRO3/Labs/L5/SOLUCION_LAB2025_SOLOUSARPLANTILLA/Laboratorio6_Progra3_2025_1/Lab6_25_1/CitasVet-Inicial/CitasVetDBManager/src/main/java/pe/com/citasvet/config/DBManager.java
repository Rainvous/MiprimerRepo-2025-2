package pe.com.citasvet.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager dbManager;
    
    private String host;
    private int puerto;
    private String esquema;
    private String usuario;
    private String password;
    
    private DBManager() throws IOException {
        cargarProperties();
    }
    
    public synchronized static DBManager getInstance() throws IOException {
        if (dbManager == null) {
            createInstance();
        }
        return dbManager;
    }
    
    private static void createInstance() throws IOException {
        dbManager = new DBManager();
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion = cadenaConexion(host, puerto, esquema);
            System.out.println("cadena_ "+cadenaConexion);
            return DriverManager.getConnection(cadenaConexion, usuario, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            throw e;
        }
    }
    
    private void cargarProperties() throws IOException {
        Properties properties = new Properties();
        String nmArchivoconf =  "jdbc.properties"; //nota en maven pones "/"+ name e ant no haces eso
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(nmArchivoconf)) {
            if (input == null) {
                System.err.println("No se pudo abrir el archivo jdbc.properties: "+nmArchivoconf);
                return;
            }
            
            properties.load(input);
            
            host = properties.getProperty("nombre_de_host_aws");
            puerto = Integer.parseInt(properties.getProperty("puerto"));
            esquema = properties.getProperty("esquema");
            usuario = properties.getProperty("usuario");
            password = properties.getProperty("password");
        }
        catch (IOException e) {
            System.err.println("No se pudo cargar el archivo "+nmArchivoconf);
            throw e;
        }
    }
    
    private String cadenaConexion(String host, int puerto, String esquema) {
        //return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true", host, puerto, esquema);
        CadenaConexionBuilder builder=new CadenaConexionBuilder().setHost(host)
                .setPuerto(puerto).setEsquema(esquema);
       // System.out.println("cadena_ "+builder.build());
        
        return builder.build();
    }
}
