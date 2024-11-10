package tn.pi.university.controllers;

import tn.pi.university.entities.Class;
import tn.pi.university.entities.Grade;
import tn.pi.university.services.ClassService;
import tn.pi.university.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private GradeService gradeService;

    /**
     * Displays the form to add a new class.
     */
    @GetMapping("/Class")
    public String showClassForm(Model model) {
        model.addAttribute("newClass", new Class());
        model.addAttribute("gradesList", gradeService.getAllGrades());
        return "ClassAdd";
    }

    /**
     * Adds a new class.
     */
    @PostMapping("/addClass")
    public String addClass(@ModelAttribute Class classEntity, HttpSession session) {
        classService.addClass(classEntity);
        session.setAttribute("msg", "Class added successfully.");
        return "redirect:/Class";
    }

    /**
     * Displays all classes.
     */
    @GetMapping("/Classshow")
    public String showAllClasses(Model model) {
        model.addAttribute("classes", classService.getAllClasses());
        return "Classshow";
    }

    /**
     * Displays the edit form for a specific class.
     */
    @GetMapping("/Classshow/edit/{id}")
    public String editClass(@PathVariable("id") long id, Model model) {
        Class classEntity = classService.getClassById(id);
        model.addAttribute("classEntity", classEntity);
        model.addAttribute("gradesList", gradeService.getAllGrades());
        return "ClassEdit";
    }

    /**
     * Updates a class.
     */
    @PostMapping("/Classshow/edit/UpdateClass")
    public String updateClass(@ModelAttribute Class classEntity, HttpSession session) {
        classService.updateClass(classEntity);
        session.setAttribute("msg", "Class updated successfully.");
        return "redirect:/Classshow";
    }

    /**
     * Deletes a class.
     */
    @GetMapping("/Classshow/delete/{id}")
    public String deleteClass(@PathVariable("id") Long id, HttpSession session) {
        classService.deleteClassById(id);
        session.setAttribute("msg", "Class deleted successfully.");
        return "redirect:/Classshow";
    }
}
