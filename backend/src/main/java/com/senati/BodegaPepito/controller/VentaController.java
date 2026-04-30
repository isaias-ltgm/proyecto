package com.senati.BodegaPepito.controller;

import com.senati.BodegaPepito.entity.Venta;
import com.senati.BodegaPepito.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {
    private final VentaService ventaService;

    // Constructor manual
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    // GET /api/ventas
    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        return ResponseEntity.ok(ventaService.listarTodos());
    }

    // GET /api/ventas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarPorId(@PathVariable Integer id) {
        return ventaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/ventas
    @PostMapping
    public ResponseEntity<Venta> crear(@RequestBody Venta venta) {
        Venta nueva = ventaService.guardar(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // PUT /api/ventas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizar(@PathVariable Integer id,
                                            @RequestBody Venta venta) {
        return ventaService.actualizar(id, venta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/ventas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return ventaService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
