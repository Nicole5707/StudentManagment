package tn.pi.university.services;

import java.util.List;
import java.util.Optional;

import tn.pi.university.entities.Student;
import tn.pi.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student getStdByID(long ID) {
        Optional<Student> model = studentRepository.findById(ID);
        return model.orElse(null);
    }

    public void deleteByStudentId(Long ID) {
        studentRepository.deleteById(ID);
    }
}
