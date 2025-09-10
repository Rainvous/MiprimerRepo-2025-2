/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.eventmastersoft.config.DBManager;

/**
 *
 * @author User
 */
public class DBManager_test {
    
    public DBManager_test() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
       @org.junit.jupiter.api.Test
    public void testGetInstance() {
        //Lo comentado no se puede hacer porque el constructor es privado
        //DBManager dbManager = new DBManager();
        System.out.println("getInstance ->");
        DBManager dbManager = DBManager.getInstance();
        if(dbManager!=null){
            System.out.println("hay isntance ->");
        }
        assertNotNull(dbManager);
        
    }
    
    @org.junit.jupiter.api.Test
    public void testGetConnection() {        
        System.out.println("getConnection");
        DBManager dbManager = DBManager.getInstance();
        Connection conexion = dbManager.getConnection();
        if(conexion==null){
            System.out.println("NO hay conect ->");
        }
        assertNotNull(conexion);       
    }
}
