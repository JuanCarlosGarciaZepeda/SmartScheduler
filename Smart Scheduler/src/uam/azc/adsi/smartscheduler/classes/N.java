package uam.azc.adsi.smartscheduler.classes;

public class N {
    private String ln;// apellido
    private String n;// nombre
    private String nk;// apodo
    private String t;// titulo

    // constructor 
    public N(){
        this.ln = "";
        this.n = "";
        this.nk = "";
        this.t = "";
    }

    // metodos
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
    
    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    // para comparar entre objetos N
    public boolean equals(N n) {
        return this.getN().equals(n.getN()) && this.getLn().equals(n.getLn());
    }

    // para mostrar los datos de N en pantalla
    public String toString() {
        String datos = "Nombre: " + this.getN() + "\n" +
                        "Apellido: " + this.getLn() + "\n" +
                        "Nickname: " + this.getNk() + "\n" +
                        "Titulo: " + this.getT() + "\n";
        return datos;
    }
}
