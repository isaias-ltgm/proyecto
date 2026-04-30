package com.minemarket.minemarket.Controller;

import com.minemarket.minemarket.Entity.Detalle_venta;
import com.minemarket.minemarket.Servirce.Detalle_VentaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Detalle_venta")
@CrossOrigin(origins = "*")
public class Detalle_VentaController {
    private final Detalle_VentaService detalle_VentaService;

    public Detalle_VentaController(Detalle_VentaService detalle_VentaService) {
        this.detalle_VentaService = detalle_VentaService;
    }

    @GetMapping
    public List<Detalle_venta> findAll() { return detalle_VentaService.findAll(); }

    @PostMapping
    public Detalle_venta save(@RequestBody Detalle_venta detalle) { return detalle_VentaService.save(detalle); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { detalle_VentaService.delete(id); }
}