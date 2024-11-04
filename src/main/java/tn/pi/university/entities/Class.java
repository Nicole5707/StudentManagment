package tn.pi.university.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "class_entity")

public class Class {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "assignedClass", cascade = CascadeType.ALL)
    private List<Student> students;


    @OneToMany(mappedBy = "classAssigned", cascade = CascadeType.ALL)
    private List<Timetable> timetables;

}
