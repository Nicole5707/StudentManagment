package com.example.Foyer;

import com.example.Foyer.entity.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoyerNicoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoyerNicoleApplication.class, args);
	}
	Etudiant newStudent = etudiantService.addStudentManually("John", "Doe", "ABC123", "Engineering College", LocalDate.of(1995, 5, 15));

}
