package com.minemarket.minemarket.Servirce;

import com.minemarket.minemarket.Entity.Venta;
import com.minemarket.minemarket.Repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {
    private VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> findAll() { return ventaRepository.findAll(); }
    public Venta save(Venta venta) { return ventaRepository.save(venta); }
    public void delete(Long id) { ventaRepository.deleteById(id); }
}