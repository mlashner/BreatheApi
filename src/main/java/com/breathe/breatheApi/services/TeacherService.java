package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Teacher;
import com.breathe.breatheApi.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    public Teacher getOrCreateTeacher(String fullName) {
        Optional<Teacher> optionalTeacher = repository.findByFullName(fullName);

        if (optionalTeacher.isPresent()) {
            return optionalTeacher.get();
        } else {
            Teacher teacher = Teacher
                    .builder()
                    .fullName(fullName)
                    .build();
            return repository.save(teacher);
        }
    }

    public Teacher updateTeacher(Teacher teacher) {
        return repository.save(teacher);
    }
}
