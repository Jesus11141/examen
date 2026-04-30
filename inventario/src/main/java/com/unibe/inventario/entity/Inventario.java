package com.unibe.inventario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entidad que representa la tabla inventario en la base de datos
@Getter
@Setter
@Entity
@Table(name = "inventario")
public class Inventario {

    // Clave primaria autogenerada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del producto en inventario
    private String nombre;

    // Descripcion del producto
    private String descripcion;

    // Cantidad disponible en inventario
    private Integer cantidad;

    // Precio unitario del producto
    private Double precio;
}
