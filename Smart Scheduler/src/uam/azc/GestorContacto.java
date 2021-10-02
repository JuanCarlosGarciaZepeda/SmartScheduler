package clases;

import java.util.ArrayList;

public class GestorContacto {
    ArrayList<Contacto> listaContactos = new ArrayList();

    // metodo de cargar el archivo que regrese la lista de contactos
    //listaContactos = funcionCargaArchivo()

    // funcion de agregar contacto que recibe un objeto de tipo contacto y lo agrega al arreglo
    public boolean agregarContacto(Contacto c){
        try{
            listaContactos.add(c);
            // hacer sort a arreglo para que al cargar la lista de nuevo el contacto agregado no
            // aparezca al final
        }finally {
            return true;
        }
    }

    // funcion de editar un contacto 
    public boolean editarContacto(Contacto c){
        // buscar el contacto en la lista
        
    }
}
