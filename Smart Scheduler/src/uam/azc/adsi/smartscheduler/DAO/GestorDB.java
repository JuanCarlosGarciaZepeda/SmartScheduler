package uam.azc.adsi.smartscheduler.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class GestorDB {
    public static final String URL = "jdbc:mysql://localhost:3306/smartsheduler";
    public static final String USER = "root";
    public static final String CLAVE = "JRayuam1985?";
    Connection conn = null;
    public boolean conecta(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Conexion Establecida ");
            return true;
         }catch(ClassNotFoundException ex){
            Logger.getLogger(MySQLContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (SQLException ex){
            Logger.getLogger(MySQLContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
   }       
    public Connection getConexion(){
        return conn;
    }   
    public boolean desconecta(){
        try{
            conn.close();
            System.out.println("Conexion Cerrada ");
            return true;
        }catch (SQLException ex){
            Logger.getLogger(MySQLContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}   
