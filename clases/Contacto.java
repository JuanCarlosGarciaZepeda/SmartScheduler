package clases;
import java.util.ArrayList;

public class Contacto{
    private String n;
    private String fn;
    private String org;
    private ArrayList<Telefono> tel;
    private ArrayList<Direccion> adr;
    private ArrayList<Email> email;
    
    /**Constructors */
    public Contacto(){
        /*    */
    }


    /**getters & setters */
    public String getN() {
        return n;
    }
    public void setN(String n) {
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
    public ArrayList<Telefono> getTel() {
        return tel;
    }
    public void setTel(ArrayList<Telefono> tel) {
        this.tel = tel;
    }
    public ArrayList<Direccion> getAdr() {
        return adr;
    }
    public void setAdr(ArrayList<Direccion> adr) {
        this.adr = adr;
    }
    public ArrayList<Email> getEmail() {
        return email;
    }
    public void setEmail(ArrayList<Email> email) {
        this.email = email;
    }
}