package co.com.Managehr.models.Vacantes;

public class CategoriaVacanteData {

    private String nombre;
    private String descripcion;
    private String nombreActual;
    private String nuevoNombre;
    private String nuevaDescripcion;

    public CategoriaVacanteData() {
        // Requerido por Cucumber para mapear la tabla de datos
    }

    public CategoriaVacanteData(String nombre,
                                String descripcion,
                                String nombreActual,
                                String nuevoNombre,
                                String nuevaDescripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreActual = nombreActual;
        this.nuevoNombre = nuevoNombre;
        this.nuevaDescripcion = nuevaDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreActual() {
        return nombreActual;
    }

    public void setNombreActual(String nombreActual) {
        this.nombreActual = nombreActual;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }

    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }
}
