package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class classEntity;
}
