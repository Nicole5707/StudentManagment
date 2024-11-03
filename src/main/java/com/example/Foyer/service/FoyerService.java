package com.example.Foyer.service;

import com.example.Foyer.entity.Foyer;
import com.example.Foyer.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoyerService {

    private final FoyerRepository foyerRepository;

    @Autowired
    public FoyerService(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer not found with id: " + id));
    }
    @Transactional
    public Foyer updateFoyer(Long id, Foyer updatedFoyer) {
        Foyer foyer = getFoyerById(id);
        foyer.setNomFoyer(updatedFoyer.getNomFoyer());
        foyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());
        return foyerRepository.save(foyer);
    }

    @Transactional
    public void deleteFoyer(Long id) {
        Foyer foyer = getFoyerById(id);
        foyerRepository.delete(foyer); 
    }
}
