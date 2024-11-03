package com.example.Foyer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foyers")
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @Column(name = "nom_foyer")
    private String nomFoyer;

    @Column(name = "capacite_foyer")
    private long capaciteFoyer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universite_id")
    private Universite universite;


    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bloc> blocs = new HashSet<>();
}
