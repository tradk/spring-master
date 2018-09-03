package com.darkness.common.many2many;

import com.darkness.entity.many2many.Student;
import com.darkness.entity.many2many.Subject;
import com.darkness.service.many2many.StudentService;
import com.darkness.service.many2many.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class Many2ManyDataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Save data
        Subject math = new Subject("Mathematics");
        Subject computer = new Subject("Compter");

        Student jack = new Student("Jack");
        Student peter = new Student("Peter");
        Set<Subject> subjects = new HashSet<Subject>();
        subjects.add(math);
        subjects.add(computer);

        jack.setSubjects(subjects);
        peter.setSubjects(subjects);

        studentService.save(jack);
        studentService.save(peter);

        Set<Student> students = new HashSet<Student>();
        students.add(jack);
        students.add(peter);
        math.setStudents(students);
        computer.setStudents(students);

        subjectService.save(math);
        subjectService.save(computer);
    }
}
