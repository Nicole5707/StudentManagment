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
@Table(name = "reservations")
public class Reservation {

    @Id
    @Column(name = "id_reservation")
    private Long idReservation;

    @Temporal(TemporalType.DATE)
    @Column(name = "annee_universitaire")
    private Date anneeUniversitaire;

    @Column(name = "est_valide")
    private boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chambre_id", nullable = false)
    private Chambre chambre;

}

