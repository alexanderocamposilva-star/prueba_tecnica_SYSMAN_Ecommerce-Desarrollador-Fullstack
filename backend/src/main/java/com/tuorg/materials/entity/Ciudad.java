package com.tuorg.materials.entity;

import jakarta.persistence.*;

/**
 * Ciudad entity.
 */
@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    @ManyToOne @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; } public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
    public Departamento getDepartamento() { return departamento; } public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
