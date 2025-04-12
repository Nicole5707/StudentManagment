package tn.pi.university.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 25, message = "Teacher must be at least 25 years old")
    private int age;

    private String address;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid phone number")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects;
}