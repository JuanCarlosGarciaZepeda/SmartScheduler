package uam.azc.adsi.smartscheduler.dao;

import java.io.IOException;

import uam.azc.adsi.smartscheduler.classes.Contacto;

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
        
    }
}
