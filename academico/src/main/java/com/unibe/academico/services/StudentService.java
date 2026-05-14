package com.unibe.academico.services;

import com.unibe.academico.entities.Student;
import com.unibe.academico.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

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
