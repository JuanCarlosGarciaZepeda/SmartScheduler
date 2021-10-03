package uam.azc.adsi.smartscheduler.classes;
import java.util.LinkedList;

public class Contacto{
    private String n;
    private String fn;
    private String org;
    private LinkedList<Telefono> tel;
    private LinkedList<Direccion> adr;
    private LinkedList<Email> email;
    
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

    

    @Override
    public String toString() {
        return "Contacto [adr=" + adr + ", email=" + email + ", fn=" + fn + ", n=" + n + ", org=" + org + ", tel=" + tel
                + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (adr == null) {
            if (other.adr != null)
                return false;
        } else if (!adr.equals(other.adr))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (fn == null) {
            if (other.fn != null)
                return false;
        } else if (!fn.equals(other.fn))
            return false;
        if (n == null) {
            if (other.n != null)
                return false;
        } else if (!n.equals(other.n))
            return false;
        if (org == null) {
            if (other.org != null)
                return false;
        } else if (!org.equals(other.org))
            return false;
        if (tel == null) {
            if (other.tel != null)
                return false;
        } else if (!tel.equals(other.tel))
            return false;
        return true;
    }

    
}