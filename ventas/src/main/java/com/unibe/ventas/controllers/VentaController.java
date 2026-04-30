package com.unibe.ventas.controllers;

import com.unibe.ventas.entities.Venta;
import com.unibe.ventas.services.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final IVentaService service;

    @GetMapping
    public Page<Venta> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Venta getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<Venta> getByCliente(@RequestParam String cliente) {
        return service.getByCliente(cliente);
    }

    @PostMapping
    public Venta create(@RequestBody Venta venta) {
        return service.create(venta);
    }

    @PutMapping("/{id}")
    public Venta updateFull(@PathVariable Long id, @RequestBody Venta venta) {
        return service.updateFull(id, venta);
    }

    @PatchMapping("/{id}")
    public Venta updatePartial(@PathVariable Long id, @RequestBody Venta venta) {
        return service.updatePartial(id, venta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
