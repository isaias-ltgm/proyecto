package com.senati.BodegaPepito.controller;

import com.senati.BodegaPepito.entity.DetalleVenta;
import com.senati.BodegaPepito.service.DetalleVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
@CrossOrigin(origins = "*")

public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    // Constructor manual
    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    // GET /api/detalles-venta
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar() {
        return ResponseEntity.ok(detalleVentaService.listarTodos());
    }

    // GET /api/detalles-venta/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> buscarPorId(@PathVariable Integer id) {
        return detalleVentaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/detalles-venta/venta/{idVenta}
    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<DetalleVenta>> listarPorVenta(@PathVariable Integer idVenta) {
        return ResponseEntity.ok(detalleVentaService.listarPorVenta(idVenta));
    }

    // GET /api/detalles-venta/producto/{idProducto}
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<DetalleVenta>> listarPorProducto(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(detalleVentaService.listarPorProducto(idProducto));
    }

    // POST /api/detalles-venta
    @PostMapping
    public ResponseEntity<DetalleVenta> crear(@RequestBody DetalleVenta detalle) {
        DetalleVenta nuevo = detalleVentaService.guardar(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT /api/detalles-venta/{id}
    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizar(@PathVariable Integer id,
                                                   @RequestBody DetalleVenta detalle) {
        return detalleVentaService.actualizar(id, detalle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/detalles-venta/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return detalleVentaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}