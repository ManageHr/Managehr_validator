package co.com.Managehr.models;

public class DatosContrato {

    private String documento;
    private String tipoContrato;
    private String estado;
    private String fechaIngreso;
    private String fechaFinal;
    private String area;
    private String cargo;
    private String archivo;

    public DatosContrato(String documento, String tipoContrato, String estado,
                         String fechaIngreso, String fechaFinal,
                         String area, String cargo, String archivo) {

        this.documento = documento;
        this.tipoContrato = tipoContrato;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinal = fechaFinal;
        this.area = area;
        this.cargo = cargo;
        this.archivo = archivo;
    }

    public String getDocumento() { return documento; }
    public String getTipoContrato() { return tipoContrato; }
    public String getEstado() { return estado; }
    public String getFechaIngreso() { return fechaIngreso; }
    public String getFechaFinal() { return fechaFinal; }
    public String getArea() { return area; }
    public String getCargo() { return cargo; }
    public String getArchivo() { return archivo; }
}
