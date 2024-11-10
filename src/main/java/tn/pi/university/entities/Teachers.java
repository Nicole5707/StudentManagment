package tn.pi.university.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String Name;
    private int Age;
    private String Address;
    private String TP;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="subject_id", referencedColumnName = "id")
    private Subjects subjects;
}
