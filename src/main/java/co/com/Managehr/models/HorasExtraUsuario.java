package co.com.Managehr.models;

import java.util.Map;

public class HorasExtraUsuario {
    private  String descripcion;
    private  String fecha;
    private  int tipo;
    private  int cantidad;

    public HorasExtraUsuario(String descripcion, String fecha, int tipo, int cantidad) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public int getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
}
