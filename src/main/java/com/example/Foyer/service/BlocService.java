package com.example.Foyer.service;

import com.example.Foyer.entity.Bloc;
import com.example.Foyer.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlocService {

    private final BlocRepository blocRepository;
    @Autowired
    public BlocService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bloc not found with id: " + id));
    }

    public Bloc updateBloc(Long id, Bloc updatedBloc) {
        Bloc bloc = getBlocById(id);
        bloc.setNomBloc(updatedBloc.getNomBloc());
        bloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());
        return blocRepository.save(bloc);
    }

    @Transactional
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

}
