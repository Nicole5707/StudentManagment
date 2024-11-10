package tn.pi.university.controllers;

import tn.pi.university.entities.Subject;
import tn.pi.university.services.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @PostMapping("addSubject")
    public String addSubject(@ModelAttribute Subject newSubject, Model model) {
        subjectsService.addSubject(newSubject);
        model.addAttribute("newSubject", new Subject());
        return "SubjectAdd";
    }

    @GetMapping("Subjects")
    public String showSubjectForm(Model model) {
        model.addAttribute("newSubject", new Subject());
        return "SubjectAdd";
    }
}
