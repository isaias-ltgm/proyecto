package com.minemarket.minemarket.Servirce;

import com.minemarket.minemarket.Entity.Detalle_venta;
import com.minemarket.minemarket.Repository.Detalle_VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Detalle_VentaService {
    private Detalle_VentaRepository detalle_VentaRepository;

    public Detalle_VentaService(Detalle_VentaRepository detalle_VentaRepository) {
        this.detalle_VentaRepository = detalle_VentaRepository;
    }

    public List<Detalle_venta> findAll() { return detalle_VentaRepository.findAll(); }
    public Detalle_venta save(Detalle_venta detalle) { return detalle_VentaRepository.save(detalle); }
    public void delete(Long id) { detalle_VentaRepository.deleteById(id); }
}