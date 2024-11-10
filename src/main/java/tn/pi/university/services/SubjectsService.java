package tn.pi.university.services;

import tn.pi.university.entities.Subjects;
import tn.pi.university.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepo;

    public Subjects addSubjects(Subjects subjects) {
        return subjectsRepo.save(subjects);
    }

    public List<Subjects> getAllSubjects() {
        return subjectsRepo.findAll();
    }
}
