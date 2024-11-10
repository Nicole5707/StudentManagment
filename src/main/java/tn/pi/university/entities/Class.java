package tn.pi.university.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // e.g., "12C"

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;  // Grade to which this class belongs

    @OneToMany(mappedBy = "classEntity")
    private List<Student> students;  // Students in this class

    @OneToMany(mappedBy = "classEntity")
    private List<Subject> subjects;  // Subjects studied by this class
}
