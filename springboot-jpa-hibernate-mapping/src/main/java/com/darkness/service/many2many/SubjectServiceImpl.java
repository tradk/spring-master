package com.darkness.service.many2many;

import com.darkness.entity.many2many.Subject;
import com.darkness.repository.many2many.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }
}
