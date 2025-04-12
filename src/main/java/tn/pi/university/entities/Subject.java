package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject name is required")
    private String name;

    private String chapters;

    @NotNull(message = "Class must be assigned")
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class classEntity;

    @NotNull(message = "Teacher must be assigned")
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}