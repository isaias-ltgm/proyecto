package com.senati.BodegaPepito.service;

import com.senati.BodegaPepito.entity.Categoria;
import com.senati.BodegaPepito.entity.Producto;
import com.senati.BodegaPepito.repository.CategoriaRepository;
import com.senati.BodegaPepito.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService{
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    // Constructor manual
    public ProductoService(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> listarPorCategoria(Integer idCategoria) {
        return productoRepository.findByCategoria_IdCategoria(idCategoria);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Integer id, Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombreProducto(productoActualizado.getNombreProducto());
            producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
            producto.setStock(productoActualizado.getStock());

            if (productoActualizado.getCategoria() != null &&
                    productoActualizado.getCategoria().getIdCategoria() != null) {
                Categoria cat = categoriaRepository
                        .findById(productoActualizado.getCategoria().getIdCategoria())
                        .orElse(null);
                producto.setCategoria(cat);
            }
            return productoRepository.save(producto);
        });
    }

    public boolean eliminar(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
