package com.unibe.ventas.services;

import com.unibe.ventas.entities.Venta;
import com.unibe.ventas.repositories.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService implements IVentaService {

    private final VentaRepository repository;

    @Override
    public Page<Venta> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Venta getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));
    }

    @Override
    public List<Venta> getByCliente(String cliente) {
        return repository.findByClienteContainingIgnoreCase(cliente);
    }

    @Override
    public Venta create(Venta venta) {
        return repository.save(venta);
    }

    @Override
    public Venta updateFull(Long id, Venta venta) {
        Venta existing = getById(id);
        existing.setCliente(venta.getCliente());
        existing.setProducto(venta.getProducto());
        existing.setCantidad(venta.getCantidad());
        existing.setPrecio(venta.getPrecio());
        existing.setFecha(venta.getFecha());
        return repository.save(existing);
    }

    @Override
    public Venta updatePartial(Long id, Venta venta) {
        Venta existing = getById(id);
        if (venta.getCliente() != null) existing.setCliente(venta.getCliente());
        if (venta.getProducto() != null) existing.setProducto(venta.getProducto());
        if (venta.getCantidad() != null) existing.setCantidad(venta.getCantidad());
        if (venta.getPrecio() != null) existing.setPrecio(venta.getPrecio());
        if (venta.getFecha() != null) existing.setFecha(venta.getFecha());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
