package com.unibe.ventas.repositories;

import com.unibe.ventas.entities.Venta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteContainingIgnoreCase(String cliente);
    Page<Venta> findAll(Pageable pageable);
}
