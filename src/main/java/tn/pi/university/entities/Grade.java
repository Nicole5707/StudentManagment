package tn.pi.university.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;  // e.g., "Year 12"

    @OneToMany(mappedBy = "grade")
    private List<Class> classes;  // List of classes in this grade
}
