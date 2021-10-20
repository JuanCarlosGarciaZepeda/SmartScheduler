package uam.azc.adsi.smartscheduler.clasesdao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uam.azc.adsi.smartscheduler.classes.Email;

/**
 *
 * @author jr_hg
 */
public class MySQLEmailDAO {
    final String INSERT = "INSERT INTO correo (email, type, contacto_idcontact) VALUES (?,?,?)";
    final String UPDATE = "UPDATE correo SET email = ?  WHERE contacto_idcontact = ? && type = ? ";
    final String DELETE = "DELETE  FROM correo WHERE contacto_idcontact = ? && type = ?";
    final String DELETEALL = "DELETE  FROM correo WHERE contacto_idcontact = ?";
    final String DELALL = "DELETE FROM correo";
    final String GETALL = "SELECT * FROM correo WHERE contacto_idcontact = ?" ;
    final String GETONE = "SELECT * FROM correo WHERE contacto_idcontact = ? && type = ?";
    private GestorDB conector;
    
    public MySQLEmailDAO ()throws IOException{
      conector = new GestorDB();
    }
    //Metodo que agrega un numeroa la tabla Telefono de un idContacto  
    public void insertar(Email a, int id) throws ExceptionDAO {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(INSERT);
            //stat.setInt(1,null);//name
            stat.setString(1,a.getEmail());//number
            stat.setString(2,a.getTipo());//type
            stat.setInt(3,id);//contacto_idcontact
            stat.executeUpdate();
            //System.out.println("guardado exitoso");
        }catch(SQLException ex){
            throw new ExceptionDAO("Error en SQL", ex);
        }finally{
            if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                new ExceptionDAO("Error en SQL", ex);
            }
        }
        if(stat != null){
            try{
                stat.close();
                conector.desconecta();
               } catch(SQLException ex){
                   throw new ExceptionDAO("Error en SQL", ex);
               }
            }
        }
    
    }
    
//Metodo que obtiene un numero de la tabla Telefono de un idContacto y de un tipo especifico  
    public Email obtener(int s, String t) {
        PreparedStatement stat = null;
        ResultSet rs = null;
         Email c = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(GETONE);
            stat.setInt(1, s);
            stat.setString(2, t);
            rs = stat.executeQuery();
           
            if(rs.next()){
                c = convertir(rs);
            }else{
                throw new SQLException ("No se encontro registro ");
            }
        }catch(SQLException ex){
            Logger.getLogger(MySQLContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                new ExceptionDAO("Error en SQL", ex);
            }
        }
        if (stat != null){
            try{
                stat.close();
                conector.desconecta();
            }catch(SQLException ex){
                
            }
        }
    }
        return c;
    }

//Metodo que modifica un numero de la tabla Telefono de un idContacto  
    public void modificar(Email a, int id) throws ExceptionDAO {
        PreparedStatement stat = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(UPDATE); 
            stat.setString(1,a.getEmail());//email
            stat.setInt(2, id);
            stat.setString(3,a.getTipo());//type
            if(stat.executeUpdate()==0){
                throw new ExceptionDAO("No se modifico el contacto");
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("Error de SQL", ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                    conector.desconecta();
                }catch(SQLException ex){
                    throw new ExceptionDAO("Error de SQL", ex);
                }
            }
        }
    }

//elimina un numero de un tipo especifico de un contacotid
    public void eliminar(int id, String t) throws ExceptionDAO {
        PreparedStatement stat = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(DELETE);
            stat.setInt(1,id);
            stat.setString(2, t);
            if(stat.executeUpdate() == 0){
                throw new ExceptionDAO("No se pudo borrar el contacto");
            } 
        }catch(SQLException ex){
            throw new ExceptionDAO("Error de SQL", ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                    conector.desconecta();
                }catch(SQLException ex){
                    throw new ExceptionDAO("Error de SQL", ex);
                }
            }
        }     
    }
  //funcion que borra todas las filas de email
    public void borraTablas() throws ExceptionDAO{
        PreparedStatement stat = null;
    try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(DELALL);
            if(stat.executeUpdate() == 0){
                throw new ExceptionDAO("No se pudo borrar la tabla");
            } 
        }catch(SQLException ex){
            throw new ExceptionDAO("Error de SQL", ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                    conector.desconecta();
                }catch(SQLException ex){
                    throw new ExceptionDAO("Error de SQL", ex);
                }
            }
        }     
}
//elimina todos los emails de un contacotid
public void eliminaTodos(int id) throws ExceptionDAO {
    PreparedStatement stat = null;
    try{
        conector.conecta();
        stat = conector.getConexion().prepareStatement(DELETEALL);
        stat.setInt(1,id);
        if(stat.executeUpdate() == 0){
            throw new ExceptionDAO("No se pudo borrar el email");
        } 
    }catch(SQLException ex){
        throw new ExceptionDAO("Error de SQL", ex);
    }finally{
        if(stat != null){
            try{
                stat.close();
                conector.desconecta();
            }catch(SQLException ex){
                throw new ExceptionDAO("Error de SQL", ex);
            }
        }
    }
    
}    
//Metodo que obtiene una lista de numeros la tabla Telefono de un idContacto  
    public LinkedList<Email> obtenerTodos(int s) throws ExceptionDAO{
         PreparedStatement stat = null;
        ResultSet rs = null;
        LinkedList<Email> emails = new LinkedList<>();
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(GETALL);
            stat.setInt(1, s);
            rs = stat.executeQuery();  
            
            while(rs.next()){
                emails.add(convertir(rs));
            }
            
        }catch(SQLException ex){
            Logger.getLogger(MySQLContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                new ExceptionDAO("Error en SQL", ex);
            }
        }
        if (stat != null){
            try{
                stat.close();
                conector.desconecta();
            }catch(SQLException ex){
                
            }
        }
    }
        return emails;
    }
    //convierte lo obtenido del resultset a un objeto de tipo telefono
     private Email convertir(ResultSet rs) throws SQLException{
       Email mail = new Email();
       mail.setEmail(rs.getString("email"));
       mail.setTipo(rs.getString("type"));
       //tel.setId(rs.getInt("contacto_idcontact"));
       return mail;
   }
}