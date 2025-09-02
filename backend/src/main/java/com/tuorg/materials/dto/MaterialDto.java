package com.tuorg.materials.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MaterialDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private BigDecimal precio;
    private LocalDate fechaCompra;
    private LocalDate fechaVenta;
    private String estado;
    private Long ciudadId;
    private String ciudadNombre;
    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; } public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTipo() { return tipo; } public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getPrecio() { return precio; } public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public java.time.LocalDate getFechaCompra() { return fechaCompra; } public void setFechaCompra(java.time.LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }
    public java.time.LocalDate getFechaVenta() { return fechaVenta; } public void setFechaVenta(java.time.LocalDate fechaVenta) { this.fechaVenta = fechaVenta; }
    public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
    public Long getCiudadId() { return ciudadId; } public void setCiudadId(Long ciudadId) { this.ciudadId = ciudadId; }
    public String getCiudadNombre() { return ciudadNombre; } public void setCiudadNombre(String ciudadNombre) { this.ciudadNombre = ciudadNombre; }
}
