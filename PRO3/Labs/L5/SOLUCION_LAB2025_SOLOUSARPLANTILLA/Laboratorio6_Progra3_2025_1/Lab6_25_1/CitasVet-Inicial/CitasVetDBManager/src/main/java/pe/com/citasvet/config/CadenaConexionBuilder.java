/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.citasvet.config;

/**
 *
 * @author User
 */
public class CadenaConexionBuilder {
    private String URL; 
    private String host;
    private String puerto;
    private String esquema;
    public CadenaConexionBuilder(){
        URL="";
        host="";
        puerto="";
        esquema="";
    }
    public CadenaConexionBuilder setHost(String host){
        this.host=host;
        
        return this;
    }
    public CadenaConexionBuilder setPuerto(int puerto){
        //Integer a=3;
        //a.toString();//OTRA FORMA
        this.puerto=""+puerto; //forma para concatener ints
        
        return this;
    }
    public CadenaConexionBuilder setEsquema(String esquema){
        this.esquema= esquema;
        return this;
    }
    //return String.format("jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true", host, puerto, esquema);
    //"jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true", host, puerto, esquema
    public String build(){
        if( host.isEmpty() || puerto.isBlank()
                || esquema.isBlank()){
            System.err.println("No se puede crear la conexcion");
            return null;
        }
        this.URL=URL+"jdbc:mysql://";
        this.URL=URL+host;
        this.URL=URL+":";
        this.URL=URL+puerto;
        this.URL=URL+"/";
        this.URL=URL+esquema;
        this.URL=URL+"?useSSL=false&allowPublicKeyRetrieval=true";
        
        return URL;
            
        
        
        
    }
    
}
