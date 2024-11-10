package tn.pi.university.services;

import tn.pi.university.entities.Student;
import tn.pi.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public void updateStudent(Student student) {
        // Assuming you want to update the student using the save method (which works for both save and update in Spring Data JPA)
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
