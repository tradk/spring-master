package com.darkness.service.many2many;

import com.darkness.entity.many2many.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);
}
