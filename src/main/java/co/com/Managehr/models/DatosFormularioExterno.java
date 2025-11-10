package co.com.Managehr.models;

public class DatosFormularioExterno {
    private String numeroDocumento;
    private String nombreCompleto;
    private String correo;
    private String confirmarCorreo;
    private String contrasenia;
    private String confirmarContrasenia;

    public DatosFormularioExterno(String numeroDocumento, String nombreCompleto, String correo, String confirmarCorreo, String contrasenia, String confirmarContrasenia) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.confirmarCorreo = confirmarCorreo;
        this.contrasenia = contrasenia;
        this.confirmarContrasenia = confirmarContrasenia;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getConfirmarCorreo() {
        return confirmarCorreo;
    }

    public void setConfirmarCorreo(String confirmarCorreo) {
        this.confirmarCorreo = confirmarCorreo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getConfirmarContrasenia() {
        return confirmarContrasenia;
    }

    public void setConfirmarContrasenia(String confirmarContrasenia) {
        this.confirmarContrasenia = confirmarContrasenia;
    }
}
