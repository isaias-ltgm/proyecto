package com.senati.BodegaPepito.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre_producto", length = 30)
    private String nombreProducto;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = true)
    private Categoria categoria;

    // Constructor vacío
    public Producto() {}

    // Constructor con todos los campos
    public Producto(Integer idProducto, String nombreProducto, Double precioUnitario,
                    Integer stock, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters
    public Integer getIdProducto() { return idProducto; }
    public String getNombreProducto() { return nombreProducto; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public Integer getStock() { return stock; }
    public Categoria getCategoria() { return categoria; }

    // Setters
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setStock(Integer stock) { this.stock = stock; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
