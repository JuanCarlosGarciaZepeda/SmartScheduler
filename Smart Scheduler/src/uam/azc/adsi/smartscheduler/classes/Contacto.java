package uam.azc.adsi.smartscheduler.classes;
import java.util.LinkedList;

public class Contacto{
    private String ln;//apellido
    private String n;//nombre
    private String nk;//apodo
    private String t;// titulo
    public String getLn() {
        return ln;
    }


    public void setLn(String ln) {
        this.ln = ln;
    }


    public String getNk() {
        return nk;
    }


    public void setNk(String nk) {
        this.nk = nk;
    }


    public String getT() {
        return t;
    }


    public void setT(String t) {
        this.t = t;
    }


    private String fn;
    private String org;
    private LinkedList<Telefono> tel;
    private LinkedList<Direccion> adr;
    private LinkedList<Email> email;
    private String photo;
    
 


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

    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
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