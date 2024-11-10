package tn.pi.university.services;

import tn.pi.university.entities.Subject;
import tn.pi.university.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepo;

    public Subject addSubject(Subject subject) {
        return subjectsRepo.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectsRepo.findAll();
    }

    public Subject getSubjectById(long id) {
        return subjectsRepo.findById(id).orElse(null);
    }

    public void updateSubject(Subject subject) {
        subjectsRepo.save(subject);
    }

    public void deleteSubjectById(Long id) {
        subjectsRepo.deleteById(id);
    }
}
