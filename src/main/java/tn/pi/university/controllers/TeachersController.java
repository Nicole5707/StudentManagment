package tn.pi.university.controllers;

import org.springframework.validation.BindingResult;
import tn.pi.university.entities.Teacher;
import tn.pi.university.services.SubjectsService;
import tn.pi.university.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private SubjectsService subjectsService;

    // Add Teacher Form
    @GetMapping("/Teacher")
    public String showTeacherForm(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        return "teachers/TeachersAdd";
    }

    // Add Teacher (Fixed Validation)
    @PostMapping("/addTeacher")
    public String addTeacher(
        @Valid @ModelAttribute("newTeacher") Teacher teacher,
        BindingResult result,
        Model model,
        HttpSession session
    ) {
        if (result.hasErrors()) {
            model.addAttribute("subjectsList", subjectsService.getAllSubjects());
            return "teachers/TeachersAdd";
        }
        teachersService.addTeacher(teacher);
        session.setAttribute("msg", "Teacher added successfully.");
        return "redirect:/Teacher";
    }

    // List All Teachers (Uncommented)
    @GetMapping("/Teachersshow")
    public String showTeachersList(Model model) {
        model.addAttribute("teachersList", teachersService.getAllTeachers());
        return "Teachersshow";
    }

    // Edit Teacher
    @GetMapping("/Teachersshow/edit/{id}")
    public String editTeacher(@PathVariable("id") long id, Model model) {
        Teacher teacher = teachersService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        return "TeacherEdit";
    }

    // Update Teacher
    @PostMapping("/Teachersshow/edit/UpdateTeacher")
    public String updateTeacher(@ModelAttribute Teacher teacher, HttpSession session) {
        teachersService.updateTeacher(teacher);
        session.setAttribute("msg", "Teacher updated successfully.");
        return "redirect:/Teachersshow";
    }

    // Delete Teacher
    @GetMapping("/Teachersshow/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id, HttpSession session) {
        teachersService.deleteTeacherById(id);
        session.setAttribute("msg", "Teacher deleted successfully.");
        return "redirect:/Teachersshow";
    }
}