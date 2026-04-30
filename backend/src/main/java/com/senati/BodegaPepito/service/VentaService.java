package com.senati.BodegaPepito.service;

import com.senati.BodegaPepito.entity.Venta;
import com.senati.BodegaPepito.repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    // Constructor manual
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Integer id) {
        return ventaRepository.findById(id);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Integer id, Venta ventaActualizada) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setTotalVenta(ventaActualizada.getTotalVenta());
            return ventaRepository.save(venta);
        });
    }

    public boolean eliminar(Integer id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
