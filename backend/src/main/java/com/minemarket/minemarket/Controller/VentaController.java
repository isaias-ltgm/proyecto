package com.minemarket.minemarket.Controller;

import com.minemarket.minemarket.Entity.Venta;
import com.minemarket.minemarket.Servirce.VentaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Venta")
@CrossOrigin(origins = "*")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> findAll() { return ventaService.findAll(); }

    @PostMapping
    public Venta save(@RequestBody Venta venta) { return ventaService.save(venta); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { ventaService.delete(id); }
}