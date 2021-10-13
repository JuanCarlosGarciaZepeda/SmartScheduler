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
    
    // lista de completos
    private LinkedList<Contacto> listaCompletos;
    
    // lista de sinFoto
    private LinkedList<Contacto> listaSinFoto;

    // constructor
    public GestorContacto(){
       this.listaContactos = new LinkedList<Contacto>();
        this.listaDuplicados = new LinkedList<Contacto>();
        this.listaIncompletos = new LinkedList<Contacto>();
        this.listaCompletos = new LinkedList<Contacto>();
        this.listaSinFoto = new LinkedList<Contacto>();
    }
    
    public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }
    public void setListaContactos(LinkedList<Contacto> lc) {
         for(Contacto c: lc){
            agregarContacto(c, this.listaContactos);
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
    LO COMENTADO MODIFICA TODO EL MÉTODO TAL QUE BUSQUE INCOMPLETOS POR INEXISTENCIA DE TEL/DIR/EMAIL EN VEZ DE POR ETIQUETAS
            
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
    
    public boolean fusionarContactos(LinkedList<Contacto> subLista, LinkedList<Contacto> listaDup){
        boolean aux = false;
        if(subLista.size()==1){
            return false;
        }
        
        Contacto fusionado = subLista.getFirst();
        
        for(int i = 1; i < subLista.size(); i++){
            if(fusionado.getN().getLn().equals(subLista.get(i).getN().getLn())){
            }else{
                
            }
            if(fusionado.getN().getN().equals(subLista.get(i).getN().getN())){}
            if(fusionado.getN().getNk().equals(subLista.get(i).getN().getNk())){}
            if(fusionado.getN().getT().equals(subLista.get(i).getN().getT())){}
            if(fusionado.getFn().equals(subLista.get(i).getFn())){}
            if(fusionado.getOrg().equals(subLista.get(i).getOrg())){}
            
            for(int j = 0; j < fusionado.getTel().size(); j++){
                for(int k = 0; k < subLista.get(i).getTel().size(); k++){
                    if(fusionado.getTel().get(j).getTipo().equals(subLista.get(i).getTel().get(k).getTipo())){}
                    if(fusionado.getTel().get(j).getTelefono().equals(subLista.get(i).getTel().get(k).getTelefono())){}
                }
            }
 
            for(int j = 0; j < fusionado.getAdr().size(); j++){
                for(int k = 0; k < subLista.get(i).getAdr().size(); k++){
                    if(fusionado.getAdr().get(j).getTipo().equals(subLista.get(i).getAdr().get(k).getTipo())){}
                    if(fusionado.getAdr().get(j).getCampo1().equals(subLista.get(i).getAdr().get(k).getCampo1())){}
                    if(fusionado.getAdr().get(j).getCampo2().equals(subLista.get(i).getAdr().get(k).getCampo2())){}
                    if(fusionado.getAdr().get(j).getCalle().equals(subLista.get(i).getAdr().get(k).getCalle())){}
                    if(fusionado.getAdr().get(j).getCiudad().equals(subLista.get(i).getAdr().get(k).getCiudad())){}
                    if(fusionado.getAdr().get(j).getEstado().equals(subLista.get(i).getAdr().get(k).getEstado())){}
                    if(fusionado.getAdr().get(j).getCp().equals(subLista.get(i).getAdr().get(k).getCp())){}
                    if(fusionado.getAdr().get(j).getPais().equals(subLista.get(i).getAdr().get(k).getPais())){}
                }
            }
            
            for(int j = 0; j < fusionado.getEmail().size(); j++){
                for(int k = 0; k < subLista.get(i).getEmail().size(); k++){
                    if(fusionado.getEmail().get(j).getTipo().equals(subLista.get(i).getEmail().get(k).getTipo())){}
                    if(fusionado.getEmail().get(j).getEmail().equals(subLista.get(i).getEmail().get(k).getEmail())){}
                }
            }
    
        }
        return aux;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void agregarContacto(Contacto c, LinkedList<Contacto> lc){
        c.setidCcontacto(this.id);
        lc.add(c);
        this.id++;
    }
    
    // funcion de editar un contacto (recibe como parametro su posicion en la lista)
    public void editarContacto(int pos, LinkedList<Contacto> lc, Contacto c){
        if(lc.get(pos).getidContacto() == c.getidContacto())
            lc.set(pos, c);
    }
    
    // Funcion que elimina un objeto de tipo contacto de la lista proporcionada
    public void eliminarContacto(Contacto c, LinkedList<Contacto> lc) {
        if(lc.contains(c)){
            lc.remove(c);
        }
    }
        
    
    public void orderLista(LinkedList<Contacto> lc){
        Collections.sort(lc);
    }

    //falta mejorar formato de impresión
    
    public void showContacts(LinkedList<Contacto> lc){
        for(Contacto c: lc){
            System.out.println(c.getFn()+" "+c.getidContacto());
        }        
    }
    
    public void searchSinFoto(){
        
        this.listaSinFoto.clear();
        
        for(Contacto c: this.listaContactos){
            if(c.getPhoto().getCadena().isEmpty()){
                this.listaSinFoto.add(c);
            }
        }
    }
    
    public void searchCompletos(){
        
        for(int i = 0; i < this.listaContactos.size(); i++){
            boolean aux = true;
            Contacto completo = this.listaContactos.get(i);
            
            if(!completo.getN().getLn().isEmpty() && 
                !completo.getN().getN().isEmpty() &&
                !completo.getN().getNk().isEmpty() &&
                !completo.getN().getT().isEmpty() &&
                !completo.getFn().isEmpty() &&
                !completo.getOrg().isEmpty()){
                
                for(int j = 0; j < completo.getTel().size(); j++){
                    if(!completo.getTel().get(j).getTipo().isEmpty() && !completo.getTel().get(j).getTelefono().isEmpty()){
                    }else{
                        aux = false;
                        break;
                    }
                }
                
                if(aux){
                    for(int j = 0; j < completo.getEmail().size(); j++){
                        if(!completo.getEmail().get(j).getTipo().isEmpty() && !completo.getEmail().get(j).getEmail().isEmpty()){
                        }else{
                            aux = false;
                            break;
                        }
                    }
                }else{
                    continue;
                }
                if(aux){
                    for(int j = 0; j < completo.getAdr().size(); j++){
                        if(!completo.getAdr().get(j).getTipo().isEmpty() &&
                            !completo.getAdr().get(j).getCampo1().isEmpty() &&
                            !completo.getAdr().get(j).getCampo2().isEmpty() &&
                            !completo.getAdr().get(j).getCalle().isEmpty() &&
                            !completo.getAdr().get(j).getCiudad().isEmpty() &&
                            !completo.getAdr().get(j).getEstado().isEmpty() &&
                            !completo.getAdr().get(j).getCp().isEmpty() &&
                            !completo.getAdr().get(j).getPais().isEmpty()){
                        }else{
                            aux = false;
                            break;
                        }
                    }
                }else{
                    continue;
                }
                
            }else{
                aux = false;
            }

            if(aux){
                this.listaCompletos.add(completo);
            }
        }
    }
    
    /*
        FALTA searchCompletos
    */
}
