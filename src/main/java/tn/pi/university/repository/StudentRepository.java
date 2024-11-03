package tn.pi.university.repository;

import com.university.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);

    // Uncomment for a custom query example
    // @Query("select s from Student s where s.firstName like :x or s.lastName like :x")
    // List<Student> searchByName(String keyword);
}
