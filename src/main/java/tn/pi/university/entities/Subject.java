package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // e.g., "Math", "Science"
    private String chapters;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class classEntity;  // The class studying this subject

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;  // Teacher assigned to this subject
}
