package uam.azc.adsi.smartscheduler.clasesdao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Telefono;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.Direccion;
public class GestorDAO {

    private MySQLContactoDAO cdao;
    private MySQLTelefonoDAO tdao;
    private MySQLDireccionDAO ddao;
    private MySQLEmailDAO edao;

    /*Constructor*/
    public GestorDAO() throws IOException{
            cdao = new MySQLContactoDAO();
            tdao = new MySQLTelefonoDAO();
            ddao = new MySQLDireccionDAO();
            edao = new MySQLEmailDAO();
    }
/*Funcion que agrega un contacto en las tablas de la BD*/
    public void createC(Contacto a) throws ExceptionDAO{
        cdao.insertar(a);
        //Contacto b = new Contacto();
        //b = cdao.obtener(a.getFn());
        int y = a.getidContacto();
        //int idd = cdao.buscarUltimoId();
        System.out.println("Se guardo el contacto con id:" + y);
        for(Telefono tel : a.getTel()){
            tdao.insertar(tel, y);
        }
        for(Direccion dir : a.getAdr()){
            ddao.insertar(dir, y);
        }
        for(Email mail : a.getEmail()){
            edao.insertar(mail, y);
        }           
    }

/*Funcion que guarda en la BD todos los contactos de una Lista de Contactos*/
    public void guardaTodos(LinkedList<Contacto> lc) throws ExceptionDAO{ 
        for(Contacto cLista : lc){       
        int y = cLista.getidContacto();   
        cdao.insertar(cLista);
        System.out.println(y);
        if (cLista.getTel().isEmpty()){
            System.out.println("Tel esta vacia ");
        } else {
            for(Telefono tel : cLista.getTel()){
                tdao.insertar(tel, y);
            }
        }
        for(Direccion dir : cLista.getAdr()){
            ddao.insertar(dir, y);
        }
        
        for(Email mail : cLista.getEmail()){
            edao.insertar(mail, y);
        }   
        System.out.println("Se guardo La lista exitosamente");
         }
    }    
    
/*Funcion que Recupera un contacto con Direccion, Telefono y Email de la BD */ 
    public Contacto recuperaUno(String s) throws ExceptionDAO{
        Contacto c = new Contacto();
        c = cdao.obtener(s);
        int idc = c.getidContacto();
        c.setTel(tdao.obtenerTodos(idc));
        c.setAdr(ddao.obtenerTodos(idc));
        c.setEmail(edao.obtenerTodos(idc));
        return c;
    }
    
/*Funcion que regresa una lista de contactos de la BD*/
    public LinkedList<Contacto> recuperaLista() throws ExceptionDAO{
        LinkedList<Contacto> Lcontactos = new LinkedList<>();
        Lcontactos = cdao.obtenerTodos();
        for(Contacto cl : Lcontactos){
            for(Telefono tel : cl.getTel()){
                cl.setTel(tdao.obtenerTodos(cl.getidContacto()));
            }
            for(Direccion dir : cl.getAdr()){
                cl.setAdr(ddao.obtenerTodos(cl.getidContacto()));
            }
            for(Email mail : cl.getEmail()){
                cl.setEmail(edao.obtenerTodos(cl.getidContacto()));
            }       
         }
        return  Lcontactos;
    }

/*Funcion que actualiza un contacto de la BD*/ 
    public void actualizaContacto(Contacto a) throws ExceptionDAO{
        cdao.modificar(a);
        int id = a.getidContacto();
        for (Telefono t : a.getTel()){
            tdao.modificar(t, id);
        }
        for (Direccion d : a.getAdr()){
            ddao.modificar(d, id);
        }
        for (Email e : a.getEmail()){
            edao.modificar(e, id);
        }
    }
    
    
/*Funcion que elimina un contacto de la base de datos*/
    public void deleteC(Contacto a) throws ExceptionDAO{
        Contacto b = new Contacto();
        b = cdao.obtener(a.getFn());
        int idd = b.getidContacto();
        System.out.println("Se quiere borrar un contacto id:"+ idd);
        tdao.eliminaTodos(idd);
        ddao.eliminaTodos(idd);
        edao.eliminaTodos(idd);
        cdao.eliminar(b);  
        System.out.println("Contacto borrado exitosamente");
    }
    

    
 
/*Funcion que regresa la cantidad de contactos existentes en la BD*/
    public int obtieneCuantos() throws ExceptionDAO{
        LinkedList<Contacto> Lcontactos = new LinkedList<>();
        Lcontactos = cdao.obtenerTodos();
        int i;
        i = Lcontactos.size();
        return i;
        /*comentario para el git*/
    }
   
    }
