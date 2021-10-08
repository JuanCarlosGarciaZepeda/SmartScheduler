package uam.azc.adsi.smartscheduler.classes;

public class Email {
    private String email;
    private String tipo;
    
    // constructor
    public Email() {}

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

    public boolean equals(Email e) {
        return this.email.equals(e.email) && this.tipo.equals(e.tipo);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }


}
