package tn.pi.university.controllers;

import tn.pi.university.entities.Student;
import tn.pi.university.entities.Subjects;
import tn.pi.university.entities.Teachers;
import tn.pi.university.services.SubjectsService;
import tn.pi.university.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private SubjectsService subjectsService;

    /**
     * Adds a new teacher with an associated subject.
     */
    @PostMapping("addTeacher")
    public String addTeacher(@ModelAttribute Teachers teacher, @ModelAttribute Subjects subject, Model model) {
        teacher.setSubjects(subject);
        teachersService.addTeacher(teacher);

        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        model.addAttribute("newTeacher", new Teachers());
        model.addAttribute("newSubject", new Subjects());

        return "TeachersAdd";
    }

    /**
     * Displays the form to add a new teacher.
     */
    @GetMapping("Teachers")
    public String showTeacherForm(Model model) {
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        model.addAttribute("newTeacher", new Teachers());
        model.addAttribute("newSubject", new Subjects());
        return "TeachersAdd";
    }

    /**
     * Displays the list of teachers.
     */
    @GetMapping("Teachersshow")
    public String showTeachersList(Model model) {
        List<Teachers> teachersList = teachersService.getTeachers();
        model.addAttribute("teachersList", teachersList);
        return "Teachersshow";
    }

    /**
     * Displays the edit form for a specific teacher.
     */
    @GetMapping("/Teachersshow/edit/{ID}")
    public String showEditTeacherForm(@PathVariable("ID") long id, Model model) {
        Teachers teacher = teachersService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "TeacherEdit";
    }

    /**
     * Updates a teacher's information.
     */
    @PostMapping("Teachersshow/edit/UpdateTeacher")
    public String updateTeacher(@ModelAttribute Teachers teacher, Model model, HttpSession session) {
        teachersService.addTeacher(teacher);
        session.setAttribute("msg", "Teacher updated successfully.");
        return "redirect:/Teachersshow";
    }
}
