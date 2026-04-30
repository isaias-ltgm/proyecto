package com.senati.BodegaPepito.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    @Column(name = "total_venta")
    private Integer totalVenta;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalles;

    // Constructor vacío
    public Venta() {}

    // Constructor con todos los campos
    public Venta(Integer idVenta, LocalDateTime fecha, Integer totalVenta, List<DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.detalles = detalles;
    }

    @PrePersist
    public void prePersist() {
        if (this.fecha == null) {
            this.fecha = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.fecha = LocalDateTime.now();
    }

    // Getters
    public Integer getIdVenta() { return idVenta; }
    public LocalDateTime getFecha() { return fecha; }
    public Integer getTotalVenta() { return totalVenta; }
    public List<DetalleVenta> getDetalles() { return detalles; }

    // Setters
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setTotalVenta(Integer totalVenta) { this.totalVenta = totalVenta; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
}
