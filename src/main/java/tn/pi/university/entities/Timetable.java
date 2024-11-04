package tn.pi.university.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Timetable {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private String time;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classAssigned;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}

