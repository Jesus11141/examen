package com.unibe.inventario.repository;

import com.unibe.inventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para acceder a la base de datos
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
