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
        return studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void updateStudent(Student student) {
    if (studentRepository.existsById(student.getId())) {
        studentRepository.save(student);
    } else {
        throw new IllegalArgumentException("Student with ID " + student.getId() + " not found.");
    }
}

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
