package com.example.Foyer.service;

import com.example.Foyer.entity.Etudiant;
import com.example.Foyer.entity.Reservation;
import com.example.Foyer.repository.EtudiantRepository;
import com.example.Foyer.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, EtudiantRepository etudiantRepository) {
        this.reservationRepository = reservationRepository;
        this.etudiantRepository = etudiantRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation reservation = getReservationById(id);
        reservation.setAnneeUniversitaire(updatedReservation.getAnneeUniversitaire());
        reservation.setEstValide(updatedReservation.isEstValide());
        reservation.setChambre(updatedReservation.getChambre());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Transactional
    public void addEtudiantToReservation(Long etudiantId, Long reservationId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + etudiantId));
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        reservation.getEtudiants().add(etudiant);
        etudiant.getReservations().add(reservation);

        reservationRepository.save(reservation);
    }

    @Transactional
    public void removeEtudiantFromReservation(Long etudiantId, Long reservationId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + etudiantId));
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        reservation.getEtudiants().remove(etudiant);
        etudiant.getReservations().remove(reservation);

        reservationRepository.save(reservation);
    }
}
