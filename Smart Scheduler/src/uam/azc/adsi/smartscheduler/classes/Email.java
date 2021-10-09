package uam.azc.adsi.smartscheduler.classes;

public class Email {
    private String email;
    private String tipo;
    
    // constructor
    public Email() {
        this.email = "";
        this.tipo = "";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // para comparar entre emails
    public boolean equals(Email e) {
        return this.email.equals(e.email);
    }

    // para mostrar datos en pantalla
    public String toString() {
        String datos = "Tipo: " + this.getTipo() + "\n" +
                        "Email: " + this.getEmail() + "\n";
        return datos;
         
    }
}
