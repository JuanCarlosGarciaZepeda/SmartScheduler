package uam.azc.adsi.smartscheduler.classes;

public class Foto {
    private String encoding;
    private String tipo;
    private String cadena;

    // constructor
    public Foto(){
        this.encoding = "";
        this.tipo = "";
        this.cadena = "";
    }

    // metodos

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCadena() {
        return this.cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        if(this.cadena.equals("")){
            return "Sin foto";
        } else {
            return "Con foto";
        }
    }

    public boolean equals(Foto f) {
        return this.cadena.equals(f.cadena) && this.tipo.equals(f.tipo);
    }
}
