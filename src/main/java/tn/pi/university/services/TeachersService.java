package tn.pi.university.services;

import tn.pi.university.entities.Teachers;
import tn.pi.university.repositories.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teacherRepo;

    public Teachers addTeacher(Teachers teachers) {
        return teacherRepo.save(teachers);
    }

    public List<Teachers> getTeachers() {
        return teacherRepo.findAll();
    }

    public Teachers getTeacherById(long ID) {
        Optional<Teachers> model = teacherRepo.findById(ID);
        return model.orElse(null);
    }
}
