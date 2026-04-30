package com.minemarket.minemarket.Repository;

import  com.minemarket.minemarket.Entity.Detalle_venta;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_VentaRepository  extends JpaRepository<Detalle_venta,Long>{
}
