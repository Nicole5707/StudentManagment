package tn.pi.university.services;

import tn.pi.university.entities.Class;
import tn.pi.university.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public void addClass(Class classEntity) {
        classRepository.save(classEntity);
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
    public Class getClassById(long id) {
        return classRepository.findById(id).orElse(null);
    }

    public void updateClass(Class classEntity) {
        classRepository.save(classEntity);
    }

    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }
}
