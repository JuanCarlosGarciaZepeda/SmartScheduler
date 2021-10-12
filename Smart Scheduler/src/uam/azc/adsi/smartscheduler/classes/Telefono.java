package uam.azc.adsi.smartscheduler.classes;

public class Telefono{
    // atributos
    private String telefono;
    private String tipo;

    //constructor
    public Telefono(){
        this.tipo = "";
        this.telefono = "";
    }
    
    // getters y setters
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // para mostrar en pantalla
    public String toString() {
        String datos = "Tipo: " + this.getTipo() + "\n" +
                        "Telefono: " + this.getTelefono() + "\n";
        return datos;
    }

    // para comparar entre telefonos
    public boolean equals(Telefono t){
        
        return this.getTipo().equals(t.getTipo()) && this.getTelefono().equals(t.getTelefono());
        
    }

    
}