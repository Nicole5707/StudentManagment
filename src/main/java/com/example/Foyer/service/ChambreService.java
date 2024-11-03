package com.example.Foyer.service;

import com.example.Foyer.entity.Chambre;
import com.example.Foyer.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChambreService {

    private final ChambreRepository chambreRepository;

    @Autowired
    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found with id: " + id));
    }

    public Chambre updateChambre(Long id, Chambre updatedChambre) {
        Chambre chambre = getChambreById(id);
        chambre.setNumeroChambre(updatedChambre.getNumeroChambre());
        chambre.setType(updatedChambre.getType());
        chambre.setBloc(updatedChambre.getBloc());
        return chambreRepository.save(chambre);
    }

    @Transactional
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}
