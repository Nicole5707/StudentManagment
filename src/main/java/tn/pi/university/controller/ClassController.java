package tn.pi.university.controller;

import tn.pi.university.entities.Class;
import tn.pi.university.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    // Endpoint to save a new class
    @PostMapping
    public Class createClass(@RequestBody Class classEntity) {
        return classRepository.save(classEntity);
    }

    // Endpoint to get all classes
    @GetMapping
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    // Endpoint to get a class by ID
    @GetMapping("/{id}")
    public Class getClassById(@PathVariable Long id) {
        return classRepository.findById(id).orElse(null);
    }
}
