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
@Table(name = "chambres")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    @Column(name = "numero_chambre", unique = true)
    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeChambre type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();
}

enum TypeChambre {
    SIMPLE, DOUBLE, TRIPLE
}
