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
        int idd = cdao.buscarUltimoId();
        System.out.println("Se guardo el contacto con id:"+idd);
        for(Telefono tel : a.getTel()){
            tdao.insertar(tel, idd);
        }
        
        for(Direccion dir : a.getAdr()){
            ddao.insertar(dir, idd);
        }
        
        for(Email mail : a.getEmail()){
            edao.insertar(mail, idd);
        }           
    }

    public void deleteC(Contacto a) throws ExceptionDAO{
        Contacto b = new Contacto();
        b = cdao.obtener(a.getFn());
        int idd = b.getidContacto();
        System.out.println("Se quiere borrar un contacto id:"+ idd);
        try{
        tdao.eliminaTodos(idd);
        ddao.eliminaTodos(idd);
        edao.eliminaTodos(idd);
        cdao.eliminar(b);
        }catch(Exception ex){
            
        }
    }

    public void guardaTodos(LinkedList<Contacto> lc) throws ExceptionDAO{
        for(Contacto con : lc ){
            cdao.insertar(con);
        }
    }

}
