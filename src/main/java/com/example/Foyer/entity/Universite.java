package com.example.Foyer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "universites")
public class Universite {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idUniversite;

        @Column(name = "nom_universite")
        private String nomUniversite;

        @Column(name = "adresse")
        private String adresse;

        @OneToOne(mappedBy = "universite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Foyer foyer;

}
