package com.senati.BodegaPepito.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "descricion", length = 200)
    private String descricion;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;

    // Constructor vacío
    public Categoria() {}

    // Constructor con todos los campos
    public Categoria(Integer idCategoria, String nombre, String descricion, List<Producto> productos) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descricion = descricion;
        this.productos = productos;
    }

    // Getters
    public Integer getIdCategoria() { return idCategoria; }
    public String getNombre() { return nombre; }
    public String getDescricion() { return descricion; }
    public List<Producto> getProductos() { return productos; }

    // Setters
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescricion(String descricion) { this.descricion = descricion; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}