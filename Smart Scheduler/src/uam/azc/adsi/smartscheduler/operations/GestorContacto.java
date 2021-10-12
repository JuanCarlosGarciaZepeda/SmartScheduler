package uam.azc.adsi.smartscheduler.operations;

import java.util.Collections;
import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.Telefono;

public class GestorContacto {
    
    private int id = 1;
        
    // lista de contactos
    private LinkedList<Contacto> listaContactos;
    
    // lista de duplicados
    private LinkedList<Contacto> listaDuplicados;
    
    // lista de incompletos
    private LinkedList<Contacto> listaIncompletos;
    
    // falta lista completos
    // falta lista sinFoto

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
   
    public void searchDup(){
        
        this.listaDuplicados.clear();
        
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
        
        this.listaIncompletos.clear();
        
        boolean aux = false;
        
        for(int i = 0; i < this.listaContactos.size(); i++){
/*
            if(this.listaContactos.get(i).getEmail().isEmpty() || this.listaContactos.get(i).getAdr().isEmpty() || this.listaContactos.get(i).getTel().isEmpty()){
                aux = true;
                //this.listaIncompletos.add(this.listaContactos.get(i));
            }
*/          
            if(this.listaContactos.get(i).getEmail().isEmpty()){
                aux = true;
            }else{
                for(Email e: this.listaContactos.get(i).getEmail()){
                    if(e.getEmail().isEmpty()){
                        aux = true;
                        break;
                    }else if(e.getTipo().isEmpty()){
                        aux = true;
                        break;
                    }
                }
            }
            
            if(this.listaContactos.get(i).getAdr().isEmpty()){
                aux = true;
            }else{
                for(Direccion c: this.listaContactos.get(i).getAdr()){
                    if(c.getTipo().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getCampo1().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getCampo2().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getCalle().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getCiudad().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getEstado().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getCp().isEmpty()){
                        aux = true;
                        break;
                    }else if(c.getPais().isEmpty()){
                        aux = true;
                        break;
                    }
                }
            }
            
            if(this.listaContactos.get(i).getTel().isEmpty()){
                aux = true;
            }else{
                for(Telefono t: this.listaContactos.get(i).getTel()){
                    if(t.getTipo().isEmpty()){
                        aux = true;
                        break;
                    }else if(t.getTelefono().isEmpty()){
                        aux = true;
                        break;
                    }
                }
            }
            
            
            if(aux){
                this.listaIncompletos.add(this.listaContactos.get(i));
                aux = false;
            }
        }
    }
    
    public boolean fusionarContactos(LinkedList<Contacto> lc){
        boolean aux = false;
        
        
    
        return aux;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void agregarContacto(Contacto c){
        c.setidCcontacto(this.id);
        this.listaContactos.add(c);
        this.id++;
    }
    
    // funcion de editar un contacto (recibe como parametro su posicion en la lista)
    public boolean editarContacto(int pos) {
        // buscar el contacto en la lista
        // antes de editar se tiene que ver si los campos del objeto son validos (REGEX)
        listaContactos.get(pos);
        return true;
    }

    public boolean eliminarDuplicado(Contacto c){
        if(listaDuplicados.contains(c)){
               listaDuplicados.remove(c);
               return true;
           }else{
               return false;
           }
    }
    
    
    // Funcion que elimina un objeto de tipo contacto de la lista de contactos
    public boolean eliminarContacto(Contacto c) {
        if(listaContactos.contains(c)){
            listaContactos.remove(c);
            return true;
        }else{
            return false;
        }
    }
    
    
    public void orderLista(LinkedList<Contacto> lc){
        Collections.sort(lc);
    }

    public void showContacts(LinkedList<Contacto> lc){
        
        //falta mejorar formato de impresión
        for(Contacto c: lc){
            System.out.println(c.getFn()+" "+c.getidContacto());
        }        
    }
}
