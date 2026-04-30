# Skill: Microservicio de Ventas

## Herramienta de IA utilizada
Amazon Q Developer (IDE Plugin - AWS)

## Prompt utilizado

> "Genera un microservicio Spring Boot con arquitectura en capas (entities, repositories, services, controllers) para gestionar Ventas con los campos: id, cliente, producto, cantidad, precio y fecha. Debe tener una API REST completa con los siguientes endpoints:
> - GET /api/ventas → listar todas con paginación
> - GET /api/ventas/{id} → buscar por ID
> - GET /api/ventas/search?cliente= → buscar por nombre de cliente
> - POST /api/ventas → crear nueva venta
> - PUT /api/ventas/{id} → actualizar completo
> - PATCH /api/ventas/{id} → actualizar parcial
> - DELETE /api/ventas/{id} → eliminar
>
> Usar PostgreSQL en puerto 5433, base de datos 'venta', usuario 'postgres', contraseña '1234'.
> Dependencias: Spring Web, Spring Boot DevTools, Lombok, Spring Data JPA, PostgreSQL Driver.
> Mismo patrón de arquitectura del proyecto academico de com.unibe."

---

## Arquitectura en Capas

### Estructura del proyecto
```
src/main/java/com/unibe/ventas/
├── entities/
│   └── Venta.java
├── repositories/
│   └── VentaRepository.java
├── services/
│   ├── IVentaService.java
│   └── VentaService.java
├── controllers/
│   └── VentaController.java
└── VentasApplication.java
```

### Capa 1 — Entity (`entities/Venta.java`)
- Representa la tabla `ventas` en la base de datos
- Anotaciones: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`
- Usa `@Data` de Lombok para generar getters, setters, toString automáticamente
- Campos: `id`, `cliente`, `producto`, `cantidad`, `precio`, `fecha`

### Capa 2 — Repository (`repositories/VentaRepository.java`)
- Extiende `JpaRepository<Venta, Long>`
- Provee operaciones CRUD automáticas sin escribir SQL
- Método personalizado: `findByClienteContainingIgnoreCase` para búsqueda por cliente
- Soporte de paginación con `Pageable`

### Capa 3 — Service (`services/`)
- `IVentaService.java` → interfaz que define los métodos del negocio
- `VentaService.java` → implementación de la interfaz con `@Service`
- Usa `@RequiredArgsConstructor` de Lombok para inyección de dependencias
- Contiene la lógica de negocio: validaciones, actualización parcial, etc.

### Capa 4 — Controller (`controllers/VentaController.java`)
- Anotado con `@RestController` y `@RequestMapping("/api/ventas")`
- Recibe las peticiones HTTP y delega al Service
- Implementa todos los verbos HTTP: GET, POST, PUT, PATCH, DELETE
- Paginación mediante `Pageable` en el endpoint GET principal

---

## Dependencias utilizadas
| Dependencia         | Uso                                      |
|---------------------|------------------------------------------|
| Spring Web          | Crear la API REST                        |
| Spring Data JPA     | Acceso a base de datos con ORM           |
| PostgreSQL Driver   | Conexión a base de datos PostgreSQL      |
| Lombok              | Reducir código boilerplate               |
| Spring Boot DevTools| Recarga automática en desarrollo         |

---

## Endpoints disponibles
| Método | Endpoint                        | Descripción              |
|--------|---------------------------------|--------------------------|
| GET    | /api/ventas?page=0&size=5       | Listar con paginación    |
| GET    | /api/ventas/{id}                | Buscar por ID            |
| GET    | /api/ventas/search?cliente=     | Buscar por cliente       |
| POST   | /api/ventas                     | Crear venta              |
| PUT    | /api/ventas/{id}                | Actualizar completo      |
| PATCH  | /api/ventas/{id}                | Actualizar parcial       |
| DELETE | /api/ventas/{id}                | Eliminar venta           |

---

## Resultado
Proyecto generado completamente a partir de este skill con arquitectura en capas, paginación y todos los endpoints REST requeridos por el examen.
