package tn.pi.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.university.entities.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
    // No additional methods needed for basic CRUD operations
}
