package tn.pi.university.repositories;
import tn.pi.university.entities.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers,Long> {
}
