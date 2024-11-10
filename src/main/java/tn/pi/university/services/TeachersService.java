package tn.pi.university.services;

import tn.pi.university.entities.Teacher;
import tn.pi.university.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
