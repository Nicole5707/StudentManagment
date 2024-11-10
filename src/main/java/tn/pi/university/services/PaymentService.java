package tn.pi.university.services;

import tn.pi.university.entities.Payment;
import tn.pi.university.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}
