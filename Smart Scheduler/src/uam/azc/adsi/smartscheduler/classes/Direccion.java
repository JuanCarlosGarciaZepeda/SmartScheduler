package uam.azc.adsi.smartscheduler.classes;

public class Direccion {
    // atributos
    private String tipo;
    private String campo1;
    private String campo2;
    private String calle;
    private String ciudad;
    private String estado;
    private String cp;
    private String pais;

    //constructor
    public Direccion(){
        this.tipo = "";
        this.campo1 = "";
        this.campo2 = "";
        this.calle = "";
        this.ciudad = "";
        this.estado = "";
        this.cp = "";
        this.pais = "";
    }

    //metodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // para comparar entre direcciones
    public boolean equals(Direccion d) {
        return this.getCalle().equals(d.getCalle()) && this.getCiudad().equals(d.getCiudad()) && this.getEstado().equals(d.getEstado());
    }

    // para imprimir la direccion
    public String toString() {
        String datos = "Tipo: " + this.getTipo() + "\n" + 
                        "Campo 1: " + this.getCampo1() + "\n" + 
                        "Campo 2: " + this.getCampo2() + "\n" +
                        "Calle: " + this.getCalle() + "\n" +
                        "Ciudad: " + this.getCiudad() + "\n" +
                        "Estado: " + this.getEstado() + "\n" +
                        "CP: " + this.getCp() + "\n" +
                        "Pais: " + this.getPais() + "\n";
        
        return datos;
    }
}
