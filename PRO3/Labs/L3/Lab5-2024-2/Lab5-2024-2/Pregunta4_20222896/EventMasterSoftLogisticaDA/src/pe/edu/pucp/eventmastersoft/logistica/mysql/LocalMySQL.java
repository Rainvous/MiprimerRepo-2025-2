package pe.edu.pucp.eventmastersoft.logistica.mysql;
import pe.edu.pucp.eventmastersoft.logistica.dao.LocalDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import pe.edu.pucp.eventmastersoft.logistica.dao.LocalDAO;
import pe.edu.pucp.eventmastersoft.logistica.model.Local;

public class LocalMySQL implements LocalDAO {

    private final String url = "jdbc:mysql://labs-1inf30-prog3-20242.czi2gssum6x2.us-east-1.rds.amazonaws.com:3306/lab04";
    private final String user = "admin";
    private final String password = "prog320242labs";

    @Override
    public int insertar(Local local) {
        int resultado = 0;
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO local (nombre, direccion, capacidad, espacio_m2, tipo_local) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, local.getNombre());
                pst.setString(2, local.getDireccion());
                pst.setInt(3, local.getCapacidad());
                pst.setDouble(4, local.getEspacioMetrosCuadrados());
                pst.setString(5, local.getTipoLocal().toString()); // Asumiendo que es enum
                resultado = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
