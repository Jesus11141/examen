# Microservicio de Inventario

## Descripción
Microservicio desarrollado manualmente para gestionar el inventario de productos.

---

## Arquitectura en Capas

### Estructura del proyecto
```
src/main/java/com/unibe/inventario/
├── entity/
│   └── Inventario.java
├── repository/
│   └── InventarioRepository.java
├── service/
│   ├── IInventarioService.java
│   └── impl/
│       └── InventarioServiceImpl.java
├── controller/
│   └── InventarioController.java
└── InventarioApplication.java
```

### Capa 1 — Entity (`entity/Inventario.java`)
- Representa la tabla `inventario` en la base de datos
- Anotaciones: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`
- Usa `@Getter` y `@Setter` de Lombok
- Campos: `id`, `nombre`, `descripcion`, `cantidad`, `precio`

### Capa 2 — Repository (`repository/InventarioRepository.java`)
- Extiende `JpaRepository<Inventario, Long>`
- Provee operaciones CRUD automáticas

### Capa 3 — Service (`service/`)
- `IInventarioService.java` → interfaz con los métodos del negocio
- `impl/InventarioServiceImpl.java` → implementación con `@Service`
- Usa `@Autowired` para inyección de dependencias

### Capa 4 — Controller (`controller/InventarioController.java`)
- Anotado con `@RestController` y `@RequestMapping("/api/inventario")`
- Usa `@Autowired` para inyección del servicio
- Implementa los endpoints GET, GET by ID y POST

---

## Dependencias utilizadas
| Dependencia         | Uso                                 |
|---------------------|-------------------------------------|
| Spring Web          | Crear la API REST                   |
| Spring Data JPA     | Acceso a base de datos con ORM      |
| PostgreSQL Driver   | Conexión a base de datos PostgreSQL |
| Lombok              | Generar getters y setters           |
| Spring Boot DevTools| Recarga automática en desarrollo    |

---

## Endpoints disponibles
| Método | Endpoint               | Descripción            |
|--------|------------------------|------------------------|
| GET    | /api/inventario        | Listar todos           |
| GET    | /api/inventario/{id}   | Buscar por ID          |
| POST   | /api/inventario        | Crear nuevo inventario |
