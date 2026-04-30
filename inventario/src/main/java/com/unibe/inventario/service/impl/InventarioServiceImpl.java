package com.unibe.inventario.service.impl;

import com.unibe.inventario.entity.Inventario;
import com.unibe.inventario.repository.InventarioRepository;
import com.unibe.inventario.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Implementacion del servicio de inventario
@Service
public class InventarioServiceImpl implements IInventarioService {

    // Inyeccion de dependencias del repositorio
    @Autowired
    private InventarioRepository inventarioRepository;

    // Listar todos los registros de inventario
    @Override
    public List<Inventario> listar() {
        return inventarioRepository.findAll();
    }

    // Buscar un inventario por su id
    @Override
    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
    }

    // Guardar un nuevo inventario en la base de datos
    @Override
    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }
}
