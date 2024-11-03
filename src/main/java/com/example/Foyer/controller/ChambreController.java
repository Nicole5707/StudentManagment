package com.example.Foyer.controller;

import com.example.Foyer.entity.Chambre;
import com.example.Foyer.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    private final ChambreService chambreService;

    @Autowired
    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.saveChambre(chambre);
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        return chambreService.updateChambre(id, chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }
}
