package uam.azc.adsi.smartscheduler.operations;

import java.util.Collections;
import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;

public class GestorContacto {
    // lista de contactos
    public LinkedList<Contacto> listaContactos;

    // constructor
    public GestorContacto(){
        this.listaContactos = new LinkedList<>();
    }

    // metodos
    // funcion de agregar contacto que recibe un objeto de tipo contacto y lo agrega
    public boolean cContact(Contacto c) {
        // antes de agregar se tiene que ver si sus campos son validos (REGEX)
        listaContactos.add(c);
        return true;
    }

    // funcion de editar un contacto (recibe como parametro su posicion en la lista)
    public boolean eContact(int pos) {
        // buscar el contacto en la lista
        // antes de editar se tiene que ver si los campos del objeto son validos (REGEX)
        listaContactos.get(pos);
        return true;
    }

    // Funcion que elimina un objeto de tipo contacto de la lista de contactos
    public boolean dContact(Contacto c) {
        if(listaContactos.contains(c)){
            listaContactos.remove(c);
            return true;
        } else {
            return false;
        }
    }

    public boolean searchDup(LinkedList<Contacto> t) {
        return true;
    }

    public boolean searchInc(LinkedList<Contacto> t) {
        return true;
    }

    public void showContacts(){
        Collections.sort(listaContactos);
        for(Contacto c: listaContactos){
            //System.out.println(c);
            System.out.println(c.getidContacto()+"\n");
            
            
        }
    }
}
