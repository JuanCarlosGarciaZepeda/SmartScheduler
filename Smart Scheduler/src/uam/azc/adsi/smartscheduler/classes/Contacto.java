package uam.azc.adsi.smartscheduler.classes;

import java.util.LinkedList;
import java.util.Objects;

public class Contacto implements Comparable<Contacto>{
    // atributos
    private int idContacto;
    private N n;
    private String fn;
    private String org;
    private LinkedList<Telefono> tel;
    private LinkedList<Direccion> adr;
    private LinkedList<Email> email;
    private Foto photo;
    private int clasificacion;
    
    /** Constructors */
    public Contacto() {
        this.idContacto = 0;
        this.n = new N();
        this.org = "";
        this.fn = "";
        this.tel = new LinkedList<>();
        this.adr = new LinkedList<>();
        this.email = new LinkedList<>();
        this.photo = new Foto();
    }

   


    /** getters & setters */
    public int getidContacto(){
        return this.idContacto;
    }

    public void setidCcontacto(int idContacto){
        this.idContacto = idContacto;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    

    public N getN(){
        return n;
    }

    public void setN(N n){
        this.n = n;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public LinkedList<Telefono> getTel() {
        return tel;
    }

    public void setTel(LinkedList<Telefono> tel) {
        this.tel = tel;
    }

    public LinkedList<Direccion> getAdr() {
        return adr;
    }

    public void setAdr(LinkedList<Direccion> adr) {
        this.adr = adr;
    }

    public LinkedList<Email> getEmail() {
        return email;
    }

    public void setEmail(LinkedList<Email> email) {
        this.email = email;
    }

    public Foto getPhoto() {
        return photo;
    }

    public void setPhoto(Foto photo) {
        this.photo = photo;
    }

    // metodos
    // agregar un telefono a la lista de telefonos
    public void agregarTelefono(Telefono t){
        tel.add(t);
    }

    // agregar direccion a lista de direcciones
    public void agregarDireccion(Direccion d){
        adr.add(d);
    }

    // agregar email a lista de emails
    public void agregarEmail(Email e){
        email.add(e);
    }
    
    // formato de impresion en consola
    public String toString() {
        String datos =  "***********************************\n" +
                        this.getN() + "\n" +
                        "-----------------------------------\n" +
                        "Nombre completo: " + this.getFn() + "\n" +
                        "-----------------------------------\n" + 
                        "Organizacion: " + this.getOrg() + "\n" +
                        "-----------------------------------\n" +
                        "Direccion: \n" + this.getAdr() + "\n" +
                        "-----------------------------------\n" +
                        "Telefono: \n" + this.getTel() + "\n" +
                        "-----------------------------------\n" +
                        "Email: \n" + this.getEmail() + "\n" +
                        "-----------------------------------\n" +
                        "Foto: \n" + this.getPhoto() + "\n" +
                        "***********************************\n";

        return datos;
    }

    
    /*
    Contacto c;        
        c.equals(OTRO Cont);
    */

    // para comparar entre contactos por su nombre
    public boolean equals(Contacto c) {
        // agregar formas de comparar un contacto con otro
        if (this == c) {
            return false;
        }
        
        if(this.fn.equals(c.getFn())){
            return true;
        }       
        
        for(int i = 0; i < c.getTel().size(); i++){
            if(this.getTel().contains(c.getTel().get(i))){
                return true;
            }
        }
        
        for(int i = 0; i < c.getEmail().size(); i++){
            if(this.getEmail().contains(c.getEmail().get(i))){
                return true;
            }
        }        
        
        return false;
    }

    // se implementa para poder ordenar a los elementos de la lista por apellido
    public int compareTo(Contacto c) {
        return this.getN().getLn().compareTo(c.getN().getLn());
    }
}