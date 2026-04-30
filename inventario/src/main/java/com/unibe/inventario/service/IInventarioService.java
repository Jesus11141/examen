package com.unibe.inventario.service;

import com.unibe.inventario.entity.Inventario;
import java.util.List;

// Interfaz que define los metodos del servicio de inventario
public interface IInventarioService {

    // Listar todos los inventarios
    List<Inventario> listar();

    // Buscar inventario por id
    Inventario buscarPorId(Long id);

    // Guardar nuevo inventario
    Inventario guardar(Inventario inventario);
}
