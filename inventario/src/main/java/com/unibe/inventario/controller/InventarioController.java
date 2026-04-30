package com.unibe.inventario.controller;

import com.unibe.inventario.entity.Inventario;
import com.unibe.inventario.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Controlador REST para el microservicio de inventario
@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    // Inyeccion del servicio
    @Autowired
    private IInventarioService inventarioService;

    // Endpoint para listar todos los inventarios
    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listar();
    }

    // Endpoint para buscar un inventario por id
    @GetMapping("/{id}")
    public Inventario buscarPorId(@PathVariable Long id) {
        return inventarioService.buscarPorId(id);
    }

    // Endpoint para crear un nuevo inventario
    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }
}
