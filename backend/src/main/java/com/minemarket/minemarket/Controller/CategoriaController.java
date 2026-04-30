package com.minemarket.minemarket.Controller;

import com.minemarket.minemarket.Entity.Categoria;
import com.minemarket.minemarket.Servirce.CategoriaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> findAll() { return categoriaService.findAll(); }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) { return categoriaService.save(categoria); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { categoriaService.delete(id); }
}