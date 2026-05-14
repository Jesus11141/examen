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
