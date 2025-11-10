package co.com.Managehr.models;

import java.util.Map;

public class HorasExtraUsuario {
    private final String descripcion;
    private final String fecha;
    private final String tipo;
    private final String cantidad;

    public HorasExtraUsuario(String descripcion, String fecha, String tipo, String cantidad) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public static HorasExtraUsuario fromMap(Map<String, String> row) {
        return new HorasExtraUsuario(
                row.getOrDefault("descripcion",""),
                row.getOrDefault("fecha",""),
                row.getOrDefault("tipo",""),
                row.getOrDefault("cantidad","")
        );
    }

    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public String getCantidad() { return cantidad; }
}
