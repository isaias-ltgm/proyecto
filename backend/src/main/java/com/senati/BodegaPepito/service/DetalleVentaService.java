package com.senati.BodegaPepito.service;

import com.senati.BodegaPepito.entity.DetalleVenta;
import com.senati.BodegaPepito.entity.Producto;
import com.senati.BodegaPepito.entity.Venta;
import com.senati.BodegaPepito.repository.DetalleVentaRepository;
import com.senati.BodegaPepito.repository.ProductoRepository;
import com.senati.BodegaPepito.repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;

    // Constructor manual
    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository,
                               ProductoRepository productoRepository,
                               VentaRepository ventaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.productoRepository = productoRepository;
        this.ventaRepository = ventaRepository;
    }

    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepository.findAll();
    }

    public Optional<DetalleVenta> buscarPorId(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    public List<DetalleVenta> listarPorVenta(Integer idVenta) {
        return detalleVentaRepository.findByVenta_IdVenta(idVenta);
    }

    public List<DetalleVenta> listarPorProducto(Integer idProducto) {
        return detalleVentaRepository.findByProducto_IdProducto(idProducto);
    }

    public DetalleVenta guardar(DetalleVenta detalle) {
        if (detalle.getProducto() != null && detalle.getProducto().getIdProducto() != null) {
            Producto p = productoRepository
                    .findById(detalle.getProducto().getIdProducto())
                    .orElse(null);
            detalle.setProducto(p);
        }
        if (detalle.getVenta() != null && detalle.getVenta().getIdVenta() != null) {
            Venta v = ventaRepository
                    .findById(detalle.getVenta().getIdVenta())
                    .orElse(null);
            detalle.setVenta(v);
        }
        return detalleVentaRepository.save(detalle);
    }

    public Optional<DetalleVenta> actualizar(Integer id, DetalleVenta detalleActualizado) {
        return detalleVentaRepository.findById(id).map(detalle -> {
            detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());

            if (detalleActualizado.getProducto() != null &&
                    detalleActualizado.getProducto().getIdProducto() != null) {
                Producto p = productoRepository
                        .findById(detalleActualizado.getProducto().getIdProducto())
                        .orElse(null);
                detalle.setProducto(p);
            }
            if (detalleActualizado.getVenta() != null &&
                    detalleActualizado.getVenta().getIdVenta() != null) {
                Venta v = ventaRepository
                        .findById(detalleActualizado.getVenta().getIdVenta())
                        .orElse(null);
                detalle.setVenta(v);
            }
            return detalleVentaRepository.save(detalle);
        });
    }

    public boolean eliminar(Integer id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
