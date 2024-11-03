package com.example.Foyer.service;

import com.example.Foyer.entity.Etudiant;
import com.example.Foyer.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
    }

    public Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant) {
        Etudiant etudiant = getEtudiantById(id);
        etudiant.setNomEt(updatedEtudiant.getNomEt());
        etudiant.setPrenomEt(updatedEtudiant.getPrenomEt());
        etudiant.setCin(updatedEtudiant.getCin());
        etudiant.setEcole(updatedEtudiant.getEcole());
        etudiant.setDateNaissance(updatedEtudiant.getDateNaissance());
        // Update additional fields if they exist
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public Etudiant addStudentManually(String nom, String prenom, String cin, String ecole, LocalDate dateNaissance) {
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setNomEt(nom);
        newEtudiant.setPrenomEt(prenom);
        newEtudiant.setCin(cin);
        newEtudiant.setEcole(ecole);
        newEtudiant.setDateNaissance(dateNaissance);
        return saveEtudiant(newEtudiant);
    }


}
