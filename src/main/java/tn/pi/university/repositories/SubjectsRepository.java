package tn.pi.university.repositories;
import tn.pi.university.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectsRepository extends JpaRepository<Subjects,Long> {
}
