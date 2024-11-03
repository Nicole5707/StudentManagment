package com.example.Foyer.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blocs")
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    @Column(name = "nom_bloc")
    private String nomBloc;

    @Column(name = "capacite_bloc")
    private long capaciteBloc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chambre> chambres = new HashSet<>();
}
