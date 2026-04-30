package com.senati.BodegaPepito.controller;

import com.senati.BodegaPepito.entity.Producto;
import com.senati.BodegaPepito.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    private final ProductoService productoService;

    // Constructor manual
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /api/productos
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.listarTodos());
    }

    // GET /api/productos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/productos/categoria/{idCategoria}
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<Producto>> listarPorCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(productoService.listarPorCategoria(idCategoria));
    }

    // POST /api/productos
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto nuevo = productoService.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT /api/productos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id,
                                               @RequestBody Producto producto) {
        return productoService.actualizar(id, producto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return productoService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
