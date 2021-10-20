package uam.azc.adsi.smartscheduler.clasesdao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uam.azc.adsi.smartscheduler.classes.Direccion;

/**
 *
 * @author jr_hg
 */
public class MySQLDireccionDAO {

    final String INSERT = "INSERT INTO direccion (type, campo1, campo2, calle, estado, ciudad, cp, pais,  contacto_idcontact) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE direccion SET  campo1 = ?, campo2 = ?, calle = ?, estado = ?, ciudad = ?, cp = ?, pais = ?  WHERE contacto_idcontact = ? && type = ?";
    final String DELETE = "DELETE  FROM direccion WHERE contacto_idcontact = ? && type = ?";
    final String DELETEALL = "DELETE  FROM direccion WHERE contacto_idcontact = ?";
    final String DELALL = "DELETE FROM direccion";
    final String GETALL = "SELECT * FROM direccion WHERE contacto_idcontact = ?" ;
    final String GETONE = "SELECT * FROM direccion WHERE contacto_idcontact = ? && type = ?";
    private GestorDB conector;
    
    public  MySQLDireccionDAO ()throws IOException{
      conector = new GestorDB();
    }
    
    //Metodo que agrega una direccion ala tabla Direccion de un idContacto  
    public void insertar(Direccion a, int id) throws ExceptionDAO {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(INSERT);
            //stat.setInt(1,null);//name
            stat.setString(1,a.getTipo());//type
            stat.setString(2,a.getCampo1());//campo 1
            stat.setString(3,a.getCampo2());//campo 2
            stat.setString(4,a.getCalle());//calle
            stat.setString(5, a.getEstado());
            stat.setString(6, a.getCiudad());
            stat.setString(7, a.getCp());
            stat.setString(8, a.getPais());
            stat.setInt(9,id);//contacto_idcontact
            stat.executeUpdate();
         //   System.out.println("guardado exitoso");
        }catch(SQLException ex){
            throw new ExceptionDAO("Error en SQL", ex);
        }finally{
            if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                throw new ExceptionDAO("Error en SQL", ex);
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
    
//Metodo que obtiene una direccion de la tabla direccion de un idContacto y de un tipo especifico  
    public Direccion obtener(int s, String t) throws ExceptionDAO {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Direccion c = null;
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
                throw new ExceptionDAO("Error en SQL", ex);
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

//Metodo que modifica una direccion de la tabla Direccion de un idContacto  
    public void modificar(Direccion a, int id) throws ExceptionDAO {
        PreparedStatement stat = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(UPDATE); 
            
            stat.setString(1,a.getCampo1());//campo 1
            stat.setString(2,a.getCampo2());//campo 2
            stat.setString(3,a.getCalle());//calle
            stat.setString(4, a.getEstado());
            stat.setString(5, a.getCiudad());
            stat.setString(6, a.getCp());
            stat.setString(7, a.getPais());
            stat.setInt(8,id);//contacto_idcontact
            stat.setString(9,a.getTipo());//type
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

  //elimina todos los numeros de la BDasociados al contacotid
  public void eliminaTodos(int id) throws ExceptionDAO {
    PreparedStatement stat = null;
    try{
        conector.conecta();
        stat = conector.getConexion().prepareStatement(DELETEALL);
        stat.setInt(1,id);
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
//Metodo que obtiene una lista de numeros la tabla Telefono de un idContacto  
    public LinkedList<Direccion> obtenerTodos(int s) throws ExceptionDAO{
         PreparedStatement stat = null;
        ResultSet rs = null;
        LinkedList<Direccion> direcciones = new LinkedList<>();
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(GETALL);
            stat.setInt(1, s);
            rs = stat.executeQuery();  
            
            while(rs.next()){
                direcciones.add(convertir(rs));
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
        return direcciones;
    }
    //convierte lo obtenido del resultset a un objeto de tipo telefono
     private Direccion convertir(ResultSet rs) throws SQLException{
       Direccion dir = new Direccion();
       //tel.setId(rs.getInt("contacto_idcontact"));
       dir.setTipo(rs.getString("type"));
       dir.setCampo1(rs.getString("campo1"));
       dir.setCampo2(rs.getString("campo2"));
       dir.setCalle(rs.getString("calle"));
       dir.setEstado(rs.getString("estado"));
       dir.setCiudad(rs.getString("ciudad"));
       dir.setCp(rs.getString("cp"));
       dir.setPais(rs.getString("pais"));
       
       return dir;
   }
    
}
