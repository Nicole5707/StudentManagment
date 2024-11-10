package tn.pi.university.controllers;

import tn.pi.university.entities.Payment;
import tn.pi.university.entities.Student;
import tn.pi.university.services.PaymentService;
import tn.pi.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/Payment")
    public String showPaymentForm(Model model) {
        model.addAttribute("newPayment", new Payment());
        model.addAttribute("studentsList", studentService.getAllStudents());
        return "PaymentAdd";
    }

    @PostMapping("/addPayment")
    public String addPayment(@ModelAttribute Payment payment) {
        paymentService.addPayment(payment);
        return "redirect:/Payment";
    }

    @GetMapping("/Payments")
    public String showAllPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "Paymentshow";
    }
}
