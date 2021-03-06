package uam.azc.adsi.smartscheduler.operations;

import java.util.Collections;
import java.util.LinkedList;
import uam.azc.adsi.smartscheduler.classes.Contacto;
import uam.azc.adsi.smartscheduler.classes.Direccion;
import uam.azc.adsi.smartscheduler.classes.Email;
import uam.azc.adsi.smartscheduler.classes.Telefono;

public class GestorContacto {
    
    private int id;
        
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
    
    // lista de sinFoto
    private LinkedList<Contacto> listaConFoto;

    // constructor
    public GestorContacto(){
       this.listaContactos = new LinkedList<Contacto>();
        this.listaDuplicados = new LinkedList<Contacto>();
        this.listaIncompletos = new LinkedList<Contacto>();
        this.listaCompletos = new LinkedList<Contacto>();
        this.listaSinFoto = new LinkedList<Contacto>();
        this.listaConFoto = new LinkedList<Contacto>();
    }

    public LinkedList<Contacto> getListaCompletos() {
        return listaCompletos;
    }
    public void setListaCompletos(LinkedList<Contacto> lc) {
        this.listaCompletos = lc;
    }

    public LinkedList<Contacto> getListaConFoto() {
        return listaConFoto;
    }

    public void setListaConFoto(LinkedList<Contacto> listaConFoto) {
        this.listaConFoto = listaConFoto;
    }
    
    

    public LinkedList<Contacto> getListaSinFoto() {
        return listaSinFoto;
    }
    public void setListaSinFoto(LinkedList<Contacto> lc) {
        this.listaSinFoto = lc;
    }
    
    public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }
    public void setListaContactos(LinkedList<Contacto> lc) {
        for(Contacto c: lc){
            agregarContacto(c, this.listaContactos);
        }
    }
    public void setContactosBD(LinkedList<Contacto> lc) {
        this.listaContactos = lc;
    }

    public LinkedList<Contacto> getListaDuplicados() {
        return listaDuplicados;
    }
    public void setListaDuplicados(LinkedList<Contacto> lc) {
        this.listaDuplicados = lc;
    }
    
    public LinkedList<Contacto> getListaIncompletos() {
        return listaIncompletos;
    }
    public void setListaIncompletos(LinkedList<Contacto> lc) {
        this.listaIncompletos = lc;
    }
   
    public void searchDup(){
        this.listaDuplicados.clear();
        
        LinkedList<Contacto> listaCopia = this.listaContactos;
      
        for(int i = 0; i < listaCopia.size(); i++){
            for(int j = i; j < this.listaContactos.size(); j++){
                if(listaCopia.get(i).equals(this.listaContactos.get(j))){
                    if(this.listaDuplicados.contains(listaCopia.get(i))){
                        if(!this.listaDuplicados.contains(this.listaContactos.get(j)))
                            this.listaDuplicados.add(this.listaContactos.get(j));
                    }else{
                        this.listaDuplicados.add(listaCopia.get(i));
                        this.listaDuplicados.add(this.listaContactos.get(j));
                    }
                }
            }
        }
        
        for(int i = 0; i < this.listaDuplicados.size(); i++){
            this.listaDuplicados.get(i).setDuplicate(true);
        }
    }

    public void searchInc(){
        this.listaIncompletos.clear();
        
        boolean aux = false;
        
        for(int i = 0; i < this.listaContactos.size(); i++){
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
        for(int i = 0; i < this.listaIncompletos.size(); i++){
            this.listaIncompletos.get(i).setComplete(false);
        }
    }
    
    public boolean fusionarContactos(LinkedList<Contacto> subLista){
        boolean aux = false;
        if(subLista.size()==1){
            return false;
        }
        Contacto fusionado = subLista.getFirst();
        for(int i = 1; i < subLista.size(); i++){
            if(!fusionado.equals(subLista.get(i))){
                return false;
            }
        }
        for(int i = 0; i < subLista.size(); i++){
            this.listaContactos.remove(subLista.get(i));
            this.listaDuplicados.remove(subLista.get(i));
        }        
        for(int i = 1; i < subLista.size(); i++){
            for(int j = 0; j < fusionado.getTel().size(); j++){
                for(int k = 0; k < subLista.get(i).getTel().size(); k++){
                    if(!fusionado.getTel().contains(subLista.get(i).getTel().get(k))){
                        fusionado.getTel().add(subLista.get(i).getTel().get(k));
                    }
                }
            }
            for(int j = 0; j < fusionado.getAdr().size(); j++){
                for(int k = 0; k < subLista.get(i).getAdr().size(); k++){
                    if(!fusionado.getAdr().contains(subLista.get(i).getAdr().get(k)))
                        fusionado.getAdr().add(subLista.get(i).getAdr().get(k));
                }
            }
            for(int j = 0; j < fusionado.getEmail().size(); j++){
                for(int k = 0; k < subLista.get(i).getEmail().size(); k++){
                    if(!fusionado.getEmail().contains(subLista.get(i).getEmail().get(k)))
                        fusionado.getEmail().add(subLista.get(i).getEmail().get(k));
                }
            }
        }
        aux = true;
        agregarContacto(fusionado, this.listaContactos);
        orderLista(this.listaContactos);
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

    //falta mejorar formato de impresi??n
    public void showContacts(LinkedList<Contacto> lc){
        for(Contacto c: lc){
            //System.out.println(c);
            System.out.println(c.getFn()+" "+c.getidContacto()+" "+c.isComplete()+" "+c.isDuplicate());
        }        
    }
    
    public void searchSinFoto(){
        this.listaSinFoto.clear();
        for(Contacto c: this.listaContactos){
            if(c.getPhoto().getCadena().isEmpty()){
                this.listaSinFoto.add(c);
            }else{
                this.listaConFoto.add(c);
            }
        }
    }
    
    public void searchCompletos(){
        
        this.listaCompletos.clear();
        
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
        
        for(int i = 0; i < this.listaCompletos.size(); i++){
            this.listaCompletos.get(i).setComplete(true);
        }
    }
}
