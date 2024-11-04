package tn.pi.university.repository;

import com.university.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByNameContains(String keyword);

    // Uncomment for a custom query example
    // @Query("select s from Subject s where s.name like :x")
    // List<Subject> searchByName(String keyword);
}
