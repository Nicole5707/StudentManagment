package tn.pi.university.controllers;

import tn.pi.university.entities.Student;
import tn.pi.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @PostMapping("addStudent")
    public String addStudent(@ModelAttribute Student student, Model model, HttpSession session) {
        studentService.addStudent(student);
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg", "Student added successfully.");
        return "StudentAdd";
    }

    @PostMapping("/AssignSubjectConfirm")
    public String assignSubjectConfirm(@ModelAttribute Student student, Model model) {
        Student existingStudent = studentService.getStdByID(student.getID());
        if (existingStudent != null) {
            existingStudent.setSubjects(student.getSubjects());
            studentService.addStudent(existingStudent);
        }
        model.addAttribute("students", studentService.getStudent());
        return "Studentshow";
    }

    @GetMapping("Student")
    public String showStudentForm(Model model) {
        model.addAttribute("newStudent", new Student());
        return "StudentAdd";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/Studentshow")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getStudent());
        return "Studentshow";
    }

    @GetMapping("/Studentshow/edit/{ID}")
    public String editStudent(@PathVariable("ID") long ID, Model model) {
        Student student = studentService.getStdByID(ID);
        if (student != null) {
            model.addAttribute("student", student);
        }
        return "StudentEdit";
    }

    @PostMapping("Studentshow/edit/UpdateStudent")
    public String updateStudent(@ModelAttribute Student student, HttpSession session) {
        studentService.addStudent(student);
        session.setAttribute("msg", "Student updated successfully.");
        return "redirect:/Studentshow";
    }

    @GetMapping("/Studentshow/delete/{ID}")
    public String deleteStudent(@PathVariable("ID") Long ID, HttpSession session) {
        studentService.deleteByStudentId(ID);
        session.setAttribute("msg", "Student with ID " + ID + " deleted successfully.");
        return "redirect:/Studentshow";
    }
}
