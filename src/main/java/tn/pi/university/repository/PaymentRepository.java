package tn.pi.university.repository;

import com.university.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentId(Long studentId);
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);

    // Uncomment for a custom query example
    // @Query("select p from Payment p where p.studentId = :studentId and p.paymentDate between :startDate and :endDate")
    // List<Payment> searchPayments(Long studentId, LocalDate startDate, LocalDate endDate);
}
