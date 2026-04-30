package com.unibe.ventas.services;

import com.unibe.ventas.entities.Venta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IVentaService {
    Page<Venta> getAll(Pageable pageable);
    Venta getById(Long id);
    List<Venta> getByCliente(String cliente);
    Venta create(Venta venta);
    Venta updateFull(Long id, Venta venta);
    Venta updatePartial(Long id, Venta venta);
    void delete(Long id);
}
