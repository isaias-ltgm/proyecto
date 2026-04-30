package com.senati.BodegaPepito.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Integer idDetalleVenta;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = true)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = true)
    private Venta venta;

    // Constructor vacío
    public DetalleVenta() {}

    // Constructor con todos los campos
    public DetalleVenta(Integer idDetalleVenta, BigDecimal precioUnitario,
                        Producto producto, Venta venta) {
        this.idDetalleVenta = idDetalleVenta;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
        this.venta = venta;
    }

    // Getters
    public Integer getIdDetalleVenta() { return idDetalleVenta; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public Producto getProducto() { return producto; }
    public Venta getVenta() { return venta; }

    // Setters
    public void setIdDetalleVenta(Integer idDetalleVenta) { this.idDetalleVenta = idDetalleVenta; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public void setVenta(Venta venta) { this.venta = venta; }
}
