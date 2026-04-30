package com.unibe.ventas.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String producto;
    private Integer cantidad;
    private Double precio;
    private LocalDate fecha;
}
