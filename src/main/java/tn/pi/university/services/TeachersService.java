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
    private TeachersRepository teacherRepo;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public Teacher getTeacherById(long id) {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        return teacher.orElse(null);
    }

    public void updateTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public void deleteTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }
}
