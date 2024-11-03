package com.example.Foyer.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "etudiants")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    @Column(name = "nom_et")
    private String nomEt;

    @Column(name = "prenom_et")
    private String prenomEt;

    @Column(name = "cin")
    private long cin;

    @Column(name = "ecole")
    private String ecole;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @ManyToMany
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private Set<Reservation> reservations = new HashSet<>();

}
