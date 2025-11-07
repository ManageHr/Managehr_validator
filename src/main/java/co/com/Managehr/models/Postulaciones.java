package co.com.Managehr.models;

import java.util.Date;

public class Postulaciones {
    private long idPostulaciones;
    private Date fechaPostulacion;
    private String estado;
    private long vacantesId;
    private long numDocumento;

    public Postulaciones(long idPostulaciones, Date fechaPostulacion, String estado, long vacantesId, long numDocumento) {
        this.idPostulaciones = idPostulaciones;
        this.fechaPostulacion = fechaPostulacion;
        this.estado = estado;
        this.vacantesId = vacantesId;
        this.numDocumento = numDocumento;
    }

    public Postulaciones() {
    }

    public long getIdPostulaciones() {
        return idPostulaciones;
    }

    public void setIdPostulaciones(long idPostulaciones) {
        this.idPostulaciones = idPostulaciones;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getVacantesId() {
        return vacantesId;
    }

    public void setVacantesId(long vacantesId) {
        this.vacantesId = vacantesId;
    }

    public long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }
}
