package tn.pi.university.repository;

import com.university.entities.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByClassId(Long classId);
    List<Timetable> findBySubjectId(Long subjectId);
    List<Timetable> findByDate(LocalDate date);

    // Uncomment for a custom query example
    // @Query("select t from Timetable t where t.classId = :classId and t.date = :date")
    // List<Timetable> findByClassAndDate(Long classId, LocalDate date);
}
