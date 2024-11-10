package tn.pi.university.controllers;

import tn.pi.university.entities.Grade;
import tn.pi.university.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class GradeController {

    @Autowired
    private GradeService gradeService;

    /**
     * Displays the form to add a new grade.
     */
    @GetMapping("/Grade")
    public String showGradeForm(Model model) {
        model.addAttribute("newGrade", new Grade());
        return "GradeAdd";
    }

    /**
     * Adds a new grade.
     */
    @PostMapping("/addGrade")
    public String addGrade(@ModelAttribute Grade grade, HttpSession session) {
        gradeService.addGrade(grade);
        session.setAttribute("msg", "Grade added successfully.");
        return "redirect:/Grade";
    }

    /**
     * Displays all grades.
     */
    @GetMapping("/Gradeshow")
    public String showAllGrades(Model model) {
        model.addAttribute("grades", gradeService.getAllGrades());
        return "Gradeshow";
    }

    /**
     * Displays the edit form for a specific grade.
     */
    @GetMapping("/Gradeshow/edit/{id}")
    public String editGrade(@PathVariable("id") long id, Model model) {
        Grade grade = gradeService.getGradeById(id);
        model.addAttribute("grade", grade);
        return "GradeEdit";
    }

    /**
     * Updates a grade.
     */
    @PostMapping("/Gradeshow/edit/UpdateGrade")
    public String updateGrade(@ModelAttribute Grade grade, HttpSession session) {
        gradeService.updateGrade(grade);
        session.setAttribute("msg", "Grade updated successfully.");
        return "redirect:/Gradeshow";
    }

    /**
     * Deletes a grade.
     */
    @GetMapping("/Gradeshow/delete/{id}")
    public String deleteGrade(@PathVariable("id") Long id, HttpSession session) {
        gradeService.deleteGradeById(id);
        session.setAttribute("msg", "Grade deleted successfully.");
        return "redirect:/Gradeshow";
    }
}
