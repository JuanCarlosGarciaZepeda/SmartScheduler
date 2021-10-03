import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

import Package 

public class SqlHelperContact{
    private GestorDB conn;

    public SqlHelperContact() throws IOException{
        conn = new GestorDB();
    }

    public Contacto add(Contacto c){
        Contacto contacto = null;
        try{
            conn.connect();
            String query = "INSERT INTO Contacto VALUES(0,?,?)";


            
        }catch(SQLException ex){
            Logger.getLogger(SqlHelperContact.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn.disconnect();
        }
        return contacto;
    }

}