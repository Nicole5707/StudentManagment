package tn.pi.university.repository;

import com.university.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContains(String keyword);

    // Uncomment for a custom query example
    // @Query("select c from Course c where c.title like :x")
    // List<Course> searchByTitle(String keyword);
}
