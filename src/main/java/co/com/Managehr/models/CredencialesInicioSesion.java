package co.com.Managehr.models;

public class CredencialesInicioSesion {
    private String email;
    private String clave;

    public CredencialesInicioSesion(String usuario, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String usuario) {
        this.email = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
