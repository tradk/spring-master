package com.darkness.service.many2many;

import com.darkness.entity.many2many.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    void save(Subject subject);
}
