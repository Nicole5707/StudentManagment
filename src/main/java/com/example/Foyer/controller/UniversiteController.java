package com.example.Foyer.controller;

import com.example.Foyer.entity.Universite;
import com.example.Foyer.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/universites")
public class UniversiteController {

    private final UniversiteService universiteService;

    @Autowired
    public UniversiteController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }
    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.saveUniversite(universite);
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return universiteService.updateUniversite(id, universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }
}