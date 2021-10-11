package uam.azc.adsi.smartscheduler.operations;

import java.util.Collections;
import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;

public class GestorContacto {
    // lista de contactos
    private LinkedList<Contacto> listaContactos;
    
    private LinkedList<Contacto> listaDuplicados;
    
    private LinkedList<Contacto> listaIncompletos;

    // constructor
    public GestorContacto(){
       this.listaContactos = new LinkedList<Contacto>();
        this.listaDuplicados = new LinkedList<Contacto>();
        this.listaIncompletos = new LinkedList<Contacto>();
    }
    
     public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(LinkedList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public LinkedList<Contacto> getListaDuplicados() {
        return listaDuplicados;
    }

    public void setListaDuplicados(LinkedList<Contacto> listaDuplicados) {
        this.listaDuplicados = listaDuplicados;
    }

    public LinkedList<Contacto> getListaIncompletos() {
        return listaIncompletos;
    }

    public void setListaIncompletos(LinkedList<Contacto> listaIncompletos) {
        this.listaIncompletos = listaIncompletos;
    }
    
    
    public void addContacto(Contacto c){
        this.listaContactos.add(c);
    }
    
    public void addDuplicado(Contacto c){
        this.listaDuplicados.add(c);
    }
    
    public void addIncompleto(Contacto c){
        this.listaIncompletos.add(c);
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

    public void searchDup(LinkedList<Contacto> listaOriginal) {
        
        System.out.println(listaOriginal.size());
        
        for(int i = 0; i < listaOriginal.size(); i++){
            for(int j = i+1; j < listaOriginal.size(); j++){
                if(listaOriginal.get(i).equals(listaOriginal.get(j))){
                    this.listaDuplicados.add(listaOriginal.get(j));
                }
            }
        }
                
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
