package com.example.Foyer.controller;

import com.example.Foyer.entity.Bloc;
import com.example.Foyer.service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {

    private final BlocService blocService;

    @Autowired
    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @PostMapping
    public Bloc createBloc(@RequestBody Bloc bloc) {
        return blocService.saveBloc(bloc);
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        return blocService.updateBloc(id, bloc);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }


}
