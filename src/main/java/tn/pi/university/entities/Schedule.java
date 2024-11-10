package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;  // The subject scheduled in this time slot
}
