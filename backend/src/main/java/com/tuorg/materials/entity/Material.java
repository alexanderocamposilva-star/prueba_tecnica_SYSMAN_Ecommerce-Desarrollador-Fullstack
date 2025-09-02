package com.tuorg.materials.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Material entity.
 */
@Entity
@Table(name = "material")
public class Material {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private BigDecimal precio;
    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;
    private String estado;
    @ManyToOne @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; } public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTipo() { return tipo; } public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getPrecio() { return precio; } public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public java.time.LocalDate getFechaCompra() { return fechaCompra; } public void setFechaCompra(java.time.LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }
    public java.time.LocalDate getFechaVenta() { return fechaVenta; } public void setFechaVenta(java.time.LocalDate fechaVenta) { this.fechaVenta = fechaVenta; }
    public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
    public Ciudad getCiudad() { return ciudad; } public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
}
