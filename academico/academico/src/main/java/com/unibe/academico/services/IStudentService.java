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
