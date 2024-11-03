package tn.pi.university.repository;

import com.university.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findByNameContains(String keyword);

    // Uncomment for a custom query example
    // @Query("select c from Class c where c.name like :x")
    // List<Class> searchByName(String keyword);
}
