package com.minemarket.minemarket.Servirce;

import com.minemarket.minemarket.Entity.Categoria;
import com.minemarket.minemarket.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll() { return categoriaRepository.findAll(); }
    public Categoria save(Categoria categoria) { return categoriaRepository.save(categoria); }
    public void delete(Long id) { categoriaRepository.deleteById(id); }
}