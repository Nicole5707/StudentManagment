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

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    // Handle GET request to show the student form
    @GetMapping("/Student")
    public String showStudentForm(Model model) {
        // Fetch the list of available classes to populate the dropdown
        model.addAttribute("newStudent", new Student());
        model.addAttribute("classes", classService.getAllClasses()); // Assuming you have a service to get all classes
        return "students/StudentAdd"; // Return the view path relative to templates folder
    }

    // Handle POST request to add a new student
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student, Model model, HttpSession session, BindingResult result) {
        // Check for validation errors
        if (result.hasErrors()) {
            // If validation fails, re-render the form with error messages
            model.addAttribute("classes", classService.getAllClasses());
            return "students/StudentAdd"; // Return to the same form with error messages
        }

        // Add student to the database using the service
        studentService.addStudent(student);

        // Set success message and reset the student form
        model.addAttribute("newStudent", new Student());
        session.setAttribute("msg", "Student added successfully.");

        // Redirect to the same form with a success message
        return "redirect:/Student"; // Redirect to the path that shows the form again
    }
}


//    @GetMapping("/Studentship")
//    public String showAllStudents(Model model) {
//        model.addAttribute("students", studentService.getAllStudents());
//        return "Studentship";
//    }
//
//    @GetMapping("/Studentship/edit/{id}")
//    public String editStudent(@PathVariable("id") long id, Model model) {
//        Student student = studentService.getStudentById(id);
//        model.addAttribute("student", student);
//        return "StudentEdit";
//    }
//
//    @PostMapping("Studentship/edit/UpdateStudent")
//    public String updateStudent(@ModelAttribute Student student, HttpSession session) {
//        studentService.updateStudent(student);
//        session.setAttribute("msg", "Student updated successfully.");
//        return "redirect:/Studentship";
//    }
//
//    @GetMapping("/Studentship/delete/{id}")
//    public String deleteStudent(@PathVariable("id") Long id, HttpSession session) {
//        studentService.deleteStudentById(id);
//        session.setAttribute("msg", "Student deleted successfully.");
//        return "redirect:/Studentship";
//    }
//}
