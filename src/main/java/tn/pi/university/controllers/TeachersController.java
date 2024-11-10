package tn.pi.university.controllers;

import tn.pi.university.entities.Subject;
import tn.pi.university.entities.Teacher;
import tn.pi.university.services.SubjectsService;
import tn.pi.university.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private SubjectsService subjectsService;

    @PostMapping("addTeacher")
    public String addTeacher(@ModelAttribute Teacher teacher, Model model) {
        teachersService.addTeacher(teacher);

        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        model.addAttribute("newTeacher", new Teacher());
        return "TeachersAdd";
    }

    @GetMapping("Teachers")
    public String showTeacherForm(Model model) {
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        model.addAttribute("newTeacher", new Teacher());
        return "TeachersAdd";
    }

    @GetMapping("Teachersshow")
    public String showTeachersList(Model model) {
        List<Teacher> teachersList = teachersService.getTeachers();
        model.addAttribute("teachersList", teachersList);
        return "Teachersshow";
    }

    @GetMapping("/Teachersshow/edit/{id}")
    public String showEditTeacherForm(@PathVariable("id") long id, Model model) {
        Teacher teacher = teachersService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        return "TeacherEdit";
    }

    @PostMapping("Teachersshow/edit/UpdateTeacher")
    public String updateTeacher(@ModelAttribute Teacher teacher, HttpSession session) {
        teachersService.addTeacher(teacher);
        session.setAttribute("msg", "Teacher updated successfully.");
        return "redirect:/Teachersshow";
    }
}
