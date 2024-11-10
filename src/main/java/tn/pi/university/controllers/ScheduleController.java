package tn.pi.university.controllers;

import tn.pi.university.entities.Schedule;
import tn.pi.university.entities.Subject;
import tn.pi.university.services.ScheduleService;
import tn.pi.university.services.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SubjectsService subjectsService;

    @GetMapping("/Schedule")
    public String showScheduleForm(Model model) {
        model.addAttribute("newSchedule", new Schedule());
        model.addAttribute("subjectsList", subjectsService.getAllSubjects());
        return "ScheduleAdd";
    }

    @PostMapping("/addSchedule")
    public String addSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.addSchedule(schedule);
        return "redirect:/Schedule";
    }

    @GetMapping("/Scheduleshow")
    public String showAllSchedules(Model model) {
        model.addAttribute("schedules", scheduleService.getAllSchedules());
        return "Scheduleshow";
    }
}
