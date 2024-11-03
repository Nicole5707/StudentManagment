package com.example.Foyer.controller;

import com.example.Foyer.entity.Foyer;
import com.example.Foyer.service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final FoyerService foyerService;

    @Autowired
    public FoyerController(FoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }
    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }


    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        return foyerService.updateFoyer(id, foyer);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }
}