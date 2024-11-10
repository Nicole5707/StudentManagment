package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String description;
    private String date;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;  // Student making this payment
}
