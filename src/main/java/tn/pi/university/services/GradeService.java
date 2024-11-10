package tn.pi.university.services;

import tn.pi.university.entities.Grade;
import tn.pi.university.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public void updateGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }
}
