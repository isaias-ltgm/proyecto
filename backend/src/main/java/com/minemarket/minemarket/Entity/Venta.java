package com.minemarket.minemarket.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column long id;

    @Column(nullable = false)
    private Timestamp fecha;

    @Column(nullable = false)
    private int total_venta;


    // GETTER O SETTER


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(int total_venta) {
        this.total_venta = total_venta;
    }

}
