package com.minemarket.minemarket.Repository;

import com.minemarket.minemarket.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
