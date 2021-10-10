package uam.azc.adsi.smartscheduler.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uam.azc.adsi.smartscheduler.classes.Contacto;

public class MySQLContactoDAO {
    final String INSERT = "INSERT INTO contacto (name, lastname, nickname, title ,fullname, organization, photo ) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE contacto SET name = ?, lastname = ?, nickname = ?, title = ?, fullname = ?, organization = ?, photo = ? WHERE idcontact = ?";
    final String DELETE = "DELETE FROM contacto WHERE fullname = ?";
    final String GETALL = "SELECT * FROM contacto" ;
    final String GETONE = "SELECT * FROM contacto WHERE fullname = ?";
    
    private GestorDB conector;
    
    public MySQLContactoDAO ()throws IOException{
      conector = new GestorDB();
    }
    
    public void insertar(Contacto a) throws ExceptionDAO {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(INSERT);
            //stat.setInt(1,null);//name
            stat.setString(1,a.getN().getN());//name
            stat.setString(2,a.getN().getLn());//lastname
            stat.setString(3,a.getN().getNk());//nickname
            stat.setString(4,a.getN().getT());//titulo
            stat.setString(5,a.getFn());//fullname
            stat.setString(6,a.getOrg());//organization
            stat.setString(7,a.getPhoto().getCadena());
            stat.executeUpdate();
            System.out.println("guardado exitoso");
            rs = stat.getGeneratedKeys();
            if (rs.next()){
                a.setidCcontacto(rs.getInt(1));
            }else{
                throw new ExceptionDAO("No se puede agregar ID a este contacto");
            }
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
    
  
    public Contacto obtener(String s) throws ExceptionDAO{
        PreparedStatement stat = null;
        ResultSet rs = null;
         Contacto c = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(GETONE);
            stat.setString(1, s);
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

 
    public void modificar(Contacto a) throws ExceptionDAO {
        PreparedStatement stat = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(UPDATE); 
            stat.setString(1,a.getN().getN());//name
            stat.setString(2,a.getN().getLn());//lastname
            stat.setString(3,a.getN().getNk());//nickname
            stat.setString(4,a.getN().getT());//titulo
            stat.setString(5,a.getFn());//fullname
            stat.setString(6,a.getOrg());//organization
            stat.setString(7,a.getPhoto().getCadena());
            stat.setInt(8,a.getidContacto());
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

    
   
    public void eliminar(Contacto a) throws ExceptionDAO {
        PreparedStatement stat = null;
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(DELETE);
            stat.setString(1,a.getFn());
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

   
    public List<Contacto> obtenerTodos() throws ExceptionDAO{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Contacto> contactos = new LinkedList<>();
        try{
            conector.conecta();
            stat = conector.getConexion().prepareStatement(GETALL);
            rs = stat.executeQuery();  
            
            while(rs.next()){
                contactos.add(convertir(rs));
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
        return contactos;
    }

   private Contacto convertir(ResultSet rs) throws SQLException{
       Foto f =new Foto();
       f.setCadena(rs.getString("photo"));
       N nombre = new N();
       nombre.setN(rs.getString("name"));
       nombre.setLn(rs.getString("lastname"));
       nombre.setNk(rs.getString("nickname"));
       nombre.setT(rs.getString("title"));
       Contacto contact = new Contacto();
       contact.setN(nombre);
       contact.setFn(nombre.getN()+""+nombre.getLn());
       contact.setOrg(rs.getString("organization"));
       contact.setPhoto(f);
       contact.setId(rs.getInt("idcontact"));
       return contact;
   }
}