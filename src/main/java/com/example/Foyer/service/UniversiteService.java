package com.example.Foyer.service;

import com.example.Foyer.entity.Universite;
import com.example.Foyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Universite not found with id: " + id));
    }

    public Universite updateUniversite(Long id, Universite updatedUniversite) {
        Universite universite = getUniversiteById(id);
        universite.setNomUniversite(updatedUniversite.getNomUniversite());
        universite.setAdresse(updatedUniversite.getAdresse());
        return universiteRepository.save(universite);
    }

    @Transactional
    public void deleteUniversite(Long id) {
        Universite universite = getUniversiteById(id);
        universiteRepository.delete(universite);
    }
}
