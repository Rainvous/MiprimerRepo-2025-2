package pe.edu.pucp.eventmastersoft.config;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBManager {
//    //Coloque sus datos de conexión
//    private static DBManager dbManager;
//    private string driver="";
//    
//    private String url = "";
//    private String usuario = "";
//    private String password = "";
//    private Connection con;
//    //    driver=com.mysql.cj.jdbc.Driver
////tipo_de_driver=jdbc:mysql
////base_de_datos=Main
////nombre_de_host=soft-inv-test.cb00kc8g8po3.us-east-1.rds.amazonaws.com
////puerto=3306
////usuario=admin
////contrasenha=Pjxriv#30
//    public static DBManager getInstance(){
//        if(dbManager == null)
//            createInstance();
//        return dbManager;
//    }
//    
//    private static void createInstance(){
//        dbManager = new DBManager();
//    }
//    
//    public Connection getConnection(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, usuario, password);
//        }catch(ClassNotFoundException | SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//        return con;
//    }
        
    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
    
    private Connection conexion;
    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String usuario;
    private String contraseña;
    
    private static DBManager dbManager = null;
    
    private DBManager(){
        //El constructor no hace nada
    }
    
    public static DBManager getInstance(){
        if (DBManager.dbManager == null)
            DBManager.createInstance();
        return DBManager.dbManager;
    }
    
    private static void createInstance() {
        if (DBManager.dbManager == null){
            DBManager.dbManager = new DBManager();
            DBManager.dbManager.leer_archivo_de_propiedades();
        }
    }
    
    public Connection getConnection(){
        try {
            Class.forName(this.driver);
            this.conexion = DriverManager.getConnection(this.getURL(), this.usuario, this.contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(DBManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return this.conexion;
    }
    
//    private String getURL() {
//        String url = this.tipo_de_driver.concat("://");
//        url = url.concat(this.nombre_de_host);
//        url = url.concat(":");
//        url = url.concat(this.puerto);
//        url = url.concat("/");
//        url = url.concat(this.base_de_datos);
//        return url;
//    }
    private String getURL() {
    String base = String.format("%s://%s:%s/%s",
            this.tipo_de_driver, this.nombre_de_host, this.puerto, this.base_de_datos);

    // Parámetros recomendados para MySQL 8 cuando no usas SSL
    String params = "?serverTimezone=UTC"
                  + "&useUnicode=true&characterEncoding=UTF-8"
                  + "&useSSL=false"
                  + "&allowPublicKeyRetrieval=true"   // evita error con caching_sha2_password
                  + "&tcpKeepAlive=true"
                  + "&connectTimeout=10000"
                  + "&socketTimeout=30000";

    return base + params;
}

    private void leer_archivo_de_propiedades() {
        //String nmArchivoConf = "/" + DBManager.ARCHIVO_CONFIGURACION;
        //Properties properties = new Properties();
       
           // properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
            this.driver = "com.mysql.cj.jdbc.Driver";// properties.getProperty("driver");
            this.tipo_de_driver = "jdbc:mysql";//properties.getProperty("tipo_de_driver");
            this.base_de_datos = "Main";//properties.getProperty("base_de_datos");
            this.nombre_de_host = "soft-inv-test.cb00kc8g8po3.us-east-1.rds.amazonaws.com";//properties.getProperty("nombre_de_host");
            this.puerto = "3306";//properties.getProperty("puerto");
            this.usuario = "admin";//properties.getProperty("usuario");
            this.contraseña = "Pjaxriv#30";//properties.getProperty("contrasenha");
       
    }  
}