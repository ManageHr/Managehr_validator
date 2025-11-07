package co.com.Managehr.models;


public class Usuario {
    private Long numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer tipoDocumento;
    private String fechaNacimiento;
    private String email;
    private String direccion;
    private String telefono;
    private Integer nacionalidad;
    private String eps;
    private String fondoPension;
    private Integer genero;
    private Integer estadoCivil;
    private String password;
    private String repetirPassword;
    private Integer rol;


    public Usuario() {}

    public Usuario(Long numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer tipoDocumento, String fechaNacimiento, String email, String direccion, String telefono, Integer nacionalidad, String eps, String fondoPension, Integer genero, Integer estadoCivil, String password, String repetirPassword, Integer rol) {
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDocumento = tipoDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.eps = eps;
        this.fondoPension = fondoPension;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.password = password;
        this.repetirPassword = repetirPassword;
        this.rol = rol;
    }

    public Long getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(Long numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getPrimerNombre() { return primerNombre; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }

    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public Integer getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(Integer tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Integer getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(Integer nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getEps() { return eps; }
    public void setEps(String eps) { this.eps = eps; }

    public String getFondoPension() { return fondoPension; }
    public void setFondoPension(String fondoPension) { this.fondoPension = fondoPension; }

    public Integer getGenero() { return genero; }
    public void setGenero(Integer genero) { this.genero = genero; }

    public Integer getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(Integer estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRepetirPassword() { return repetirPassword; }
    public void setRepetirPassword(String repetirPassword) { this.repetirPassword = repetirPassword; }

    public Integer getRol() { return rol; }
    public void setRol(Integer rol) { this.rol = rol; }
}