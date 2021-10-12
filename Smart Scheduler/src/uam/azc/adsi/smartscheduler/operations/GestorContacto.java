package uam.azc.adsi.smartscheduler.operations;

import java.util.Collections;
import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;

public class GestorContacto {
    
    private int id = 1;
        
    // lista de contactos
    private LinkedList<Contacto> listaContactos;
    
    // lista de duplicados
    private LinkedList<Contacto> listaDuplicados;
    
    // lista de incompletos
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
         for(Contacto c: listaContactos){
            agregarContacto(c);
        }
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
        }else{
            return false;
        }
    }

    public void searchDup(){
        
        LinkedList<Contacto> listaCopia = this.listaContactos;
        
        for(int i = 0; i < listaCopia.size(); i++){
            for(int j = i; j < this.listaContactos.size(); j++){
                if(listaCopia.get(i).equals(this.listaContactos.get(j))){
                    if(this.listaDuplicados.contains(listaCopia.get(i))){
                        this.listaDuplicados.add(this.listaContactos.get(j));
                    }
                    else{
                        this.listaDuplicados.add(listaCopia.get(i));
                        this.listaDuplicados.add(this.listaContactos.get(j));
                    }
                }
            }
        }
    }

    public void searchInc(){
        //pendiente
        
        // que sea por email y dirección
    }
    
    public int getId(){
        return this.id;
    }
    
    public void agregarContacto(Contacto c){
        c.setidCcontacto(this.id);
        this.listaContactos.add(c);
        this.id++;
    }
    
    
    
    public void orderLista(LinkedList<Contacto> lc){
        Collections.sort(lc);
    }

    public void showContacts(LinkedList<Contacto> lc){
        for(Contacto c: lc){
            System.out.println(c.getFn()+" "+c.getidContacto());
        }        
    }
}
