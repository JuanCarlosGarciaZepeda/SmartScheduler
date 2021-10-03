
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GestorDB {
    private Connection conn;
    private String stringConn;
    private Properties configuration;
    
    public GestorDB() throws FileNotFoundException, IOException{

    String path = System.getProperty("user.dir") + System.getProperty("file.separator");
    FileInputStream fi = new FileInputStream( path + "prop.properties");
    configuration = new Properties();
    configuration.load(fi);

    String host = configuration.getProperty("host");
    String port = configuration.getProperty("port");
    String dbName = configuration.getProperty("dbName");
    String user = configuration.getProperty("user");
    String password = configuration.getProperty("password");

    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("jdbc:mysql://");
    strBuilder.append(host);
    strBuilder.append(":");
    strBuilder.append(port);
    strBuilder.append("/");
    strBuilder.append(dbName);
    strBuilder.append("?user=");
    strBuilder.append(user);
    strBuilder.append("&password=");
    strBuilder.append(password);
    stringConn = strBuilder.toString();
    }
    
    public boolean connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(stringConn);
            return true;
        }catch(ClassNotFoundException ex){
            Logger.getLogger(SqlHelperContact.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (SQLException ex){
            Logger.getLogger(SqlHelperContact.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean disconnect(){
        try{
            conn.close();
            return true;
        }catch (SQLException ex){
            Logger.getLogger(SqlHelperContact.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Connection getConn(){
        return conn;
    }

}   