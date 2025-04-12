package tn.pi.university.controllers;

import org.springframework.validation.BindingResult;
import tn.pi.university.entities.Student;
import tn.pi.university.services.ClassService;
import tn.pi.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    // Add Student Form
    @GetMapping("/Student")
    public String showStudentForm(Model model) {
        model.addAttribute("newStudent", new Student());
        model.addAttribute("classes", classService.getAllClasses());
        return "students/StudentAdd";
    }

    // Add Student
    @PostMapping("/addStudent")
    public String addStudent(
        @Valid @ModelAttribute("newStudent") Student student,
        BindingResult result,
        Model model,
        HttpSession session
    ) {
        if (result.hasErrors()) {
            model.addAttribute("classes", classService.getAllClasses());
            return "students/StudentAdd";
        }
        studentService.addStudent(student);
        session.setAttribute("msg", "Student added successfully.");
        return "redirect:/Student";
    }

    // List All Students (Uncommented)
    @GetMapping("/Studentship")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "Studentship";
    }

    // Edit Student
    @GetMapping("/Studentship/edit/{id}")
    public String editStudent(@PathVariable("id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("classes", classService.getAllClasses());
        return "StudentEdit";
    }

    // Update Student
    @PostMapping("/Studentship/edit/UpdateStudent")
    public String updateStudent(@ModelAttribute Student student, HttpSession session) {
        studentService.updateStudent(student);
        session.setAttribute("msg", "Student updated successfully.");
        return "redirect:/Studentship";
    }

    // Delete Student
    @GetMapping("/Studentship/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, HttpSession session) {
        studentService.deleteStudentById(id);
        session.setAttribute("msg", "Student deleted successfully.");
        return "redirect:/Studentship";
    }
}