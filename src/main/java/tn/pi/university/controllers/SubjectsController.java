package tn.pi.university.controllers;

import tn.pi.university.entities.Student;
import tn.pi.university.entities.Subjects;
import tn.pi.university.services.StudentService;
import tn.pi.university.services.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @Autowired
    private StudentService studentService;

    /**
     * Adds a new subject to the database.
     */
    @PostMapping("addSubject")
    public String addSubject(@ModelAttribute Subjects newSubject, Model model) {
        subjectsService.addSubjects(newSubject);
        model.addAttribute("newSubject", new Subjects());
        return "SubjectAdd";
    }

    /**
     * Displays the subject addition form.
     */
    @GetMapping("Subjects")
    public String showSubjectForm(Model model) {
        model.addAttribute("newSubject", new Subjects());
        return "SubjectAdd";
    }

    /**
     * Displays the page to assign subjects to students.
     */
    @GetMapping("AssignSub")
    public String showAssignSubjectPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("studentsList", studentService.getStudent());
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        return "AssignSub";
    }
}
