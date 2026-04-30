package com.minemarket.minemarket.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Detalle_venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column long id;


    @Column(nullable = false)
    private BigDecimal precio_unitario;



    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    //GETTER O SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
