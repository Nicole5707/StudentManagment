package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;  // Subjects taught by this teacher
}
