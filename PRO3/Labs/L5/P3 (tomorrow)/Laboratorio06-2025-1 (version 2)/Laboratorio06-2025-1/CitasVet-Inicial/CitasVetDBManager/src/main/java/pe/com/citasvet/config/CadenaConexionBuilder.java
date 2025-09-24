package pe.com.citasvet.config;

/**
 *
 * @author ferro
 */
public class CadenaConexionBuilder {

    private String host;
    private int puerto;
    private String esquema;
    
    public CadenaConexionBuilder(){
        
        this.host = null;
        this.puerto = 0;
        this.esquema = null;
    }

    public CadenaConexionBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public CadenaConexionBuilder setPuerto(int puerto) {
        this.puerto = puerto;
        return this;
    }

    public CadenaConexionBuilder setEsquema(String esquema) {
        this.esquema = esquema;
        return this;
    }

    public String build() {
        // jdbc:mysql://%s:%d/%s?useSSL=false&allowPublicKeyRetrieval=true
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://")
                .append(host)
                .append(":")
                .append(puerto)
                .append("/")
                .append(esquema)
                .append("?useSSL=false&allowPublicKeyRetrieval=true");

        return sb.toString();
    }
}

