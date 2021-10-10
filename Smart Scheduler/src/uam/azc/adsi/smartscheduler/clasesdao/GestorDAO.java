package uam.azc.adsi.smartscheduler.clasesdao;

import java.io.IOException;
import java.util.LinkedList;

import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Telefono;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.Direccion;
public class GestorDAO {
    MySQLContactoDAO cdao;
    MySQLTelefonoDAO tdao;
    MySQLDireccionDAO ddao;
    MySQLEmailDAO edao;
    /*Constructor*/
    public GestorDAO() throws IOException{
            cdao = new MySQLContactoDAO();
            tdao = new MySQLTelefonoDAO();
            ddao = new MySQLDireccionDAO();
            edao = new MySQLEmailDAO();
    }
    //Funcion que agrega un contacto en las tablas de la BD
    public void createC(Contacto a) throws ExceptionDAO{
        cdao.insertar(a);
        Contacto b = new Contacto();
        b = cdao.obtener(a.getFn());
        int y = b.getidContacto();
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

    public void deleteC(Contacto a) throws ExceptionDAO{
        Contacto b = new Contacto();
        b = cdao.obtener(a.getFn());
        int idd = b.getidContacto();
        System.out.println("Se quiere borrar un contacto id:"+ idd);
        tdao.eliminaTodos(idd);
        ddao.eliminaTodos(idd);
        edao.eliminaTodos(idd);
        cdao.eliminar(b);
       
    }

    public void guardaTodos(LinkedList<Contacto> lc) throws ExceptionDAO{
         for(int i = 0; i<lc.size();i++ ){
            System.out.println("guardare:"+lc.get(i).getFn());
            cdao.insertar(lc.get(i));
             Contacto b = new Contacto();
         b = cdao.obtener(lc.get(i).getFn());
        int y = b.getidContacto();
         
        for(Telefono tel : lc.get(i).getTel()){
            tdao.insertar(tel, y);
        }
        
        for(Direccion dir : lc.get(i).getAdr()){
            ddao.insertar(dir, y);
        }
        
        for(Email mail : lc.get(i).getEmail()){
            edao.insertar(mail, y);
        }   
        System.out.println("Se guardo el contacto exitosamente");
        }
    }
    }
