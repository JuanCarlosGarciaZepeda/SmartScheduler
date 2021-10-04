package uam.azc.adsi.smartscheduler.operations;

import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;

public class GestorContacto {
    LinkedList<Contacto> listaContactos = new LinkedList();

    // metodo de cargar el archivo que regrese la lista de contactos
    //listaContactos = funcionCargaArchivo()

    // funcion de agregar contacto que recibe un objeto de tipo contacto y lo agrega al arreglo
    public boolean cContact(Contacto c){
        try{
            listaContactos.add(c);
            // hacer sort a arreglo para que al cargar la lista de nuevo el contacto agregado no
            // aparezca al final
        }finally {
            return true;
        }
    }

    // funcion de editar un contacto 
    public boolean eContact(Contacto c){
        // buscar el contacto en la lista
        return true;
    }

    public boolean dContact(Contacto c){
        return true;
    }

    public boolean searchDup(LinkedList<Contacto> t){
    return true;
    }

    public boolean searchInc(LinkedList<Contacto> t){
        return true;
    }
}
