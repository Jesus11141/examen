# Skill: Client Microservice Generator (Spring Boot)

## 🎯 Objective
Generate a complete microservice called **academico** using Spring Boot with a layered architecture.

---

## ⚙️ Context

| Item | Value |
|------|-------|
| Project Name | academico |
| Built with | Java 17, Maven, Lombok enabled, PostgreSQL database |
| Base package | `com.unibe.academico` |
| Main Entity | Student |

---

## 📂 Required Structure

```
src/main/java/com/unibe/academico/
├── entities/
│   └── Student.java
├── repositories/
│   └── StudentRepository.java
├── services/
│   ├── IStudentService.java
│   └── impl/
│       └── StudentServiceImpl.java
├── controllers/
│   └── StudentController.java
└── AcademicoApplication.java
```

---

## 🛠️ Instructions

### 1. Create Entity: Student

`entities/Student.java`

```java
package com.unibe.academico.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean state;
}
```

---

### 2. Create Repository Layer

`repositories/StudentRepository.java`

```java
package com.unibe.academico.repositories;

import com.unibe.academico.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

---

### 3. Create Service Layer (Interface)

`services/IStudentService.java`

```java
package com.unibe.academico.services;

import com.unibe.academico.entities.Student;
import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student create(Student student);
    Student updateFull(Long id, Student student);
    Student updatePartial(Long id, Student student);
    void delete(Long id);
}
```

---

### 4. Create Service Implementation

`services/impl/StudentServiceImpl.java`

```java
package com.unibe.academico.services.impl;

import com.unibe.academico.entities.Student;
import com.unibe.academico.repositories.StudentRepository;
import com.unibe.academico.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateFull(Long id, Student student) {
        Student existing = getById(id);
        existing.setName(student.getName());
        existing.setState(student.getState());
        return repository.save(existing);
    }

    @Override
    public Student updatePartial(Long id, Student student) {
        Student existing = getById(id);
        if (student.getName() != null) existing.setName(student.getName());
        if (student.getState() != null) existing.setState(student.getState());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
```

---

### 5. Create Controller Layer

`controllers/StudentController.java`

```java
package com.unibe.academico.controllers;

import com.unibe.academico.entities.Student;
import com.unibe.academico.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}")
    public Student updateFull(@PathVariable Long id, @RequestBody Student student) {
        return service.updateFull(id, student);
    }

    @PatchMapping("/{id}")
    public Student updatePartial(@PathVariable Long id, @RequestBody Student student) {
        return service.updatePartial(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
```

---

### 6. Configure PostgreSQL Database

`src/main/resources/application.properties`

```properties
spring.application.name=academico

spring.datasource.url=jdbc:postgresql://localhost:5432/academico
spring.datasource.username=postgres
spring.datasource.password=12345
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### 7. Build Configuration (pom.xml dependencies)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

---

## 🧪 Endpoints Summary

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create new student |
| PUT | `/api/students/{id}` | Full update |
| PATCH | `/api/students/{id}` | Partial update |
| DELETE | `/api/students/{id}` | Delete student |

---

## 📝 Example Request Body

```json
{
  "name": "Juan Pérez",
  "state": true
}
```
