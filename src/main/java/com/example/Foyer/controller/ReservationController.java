package com.example.Foyer.controller;

import com.example.Foyer.entity.Reservation;
import com.example.Foyer.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

    @PostMapping("/{reservationId}/etudiants/{etudiantId}")
    public ResponseEntity<Void> addEtudiantToReservation(@PathVariable Long reservationId, @PathVariable Long etudiantId) {
        reservationService.addEtudiantToReservation(etudiantId, reservationId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{reservationId}/etudiants/{etudiantId}")
    public ResponseEntity<Void> removeEtudiantFromReservation(@PathVariable Long reservationId, @PathVariable Long etudiantId) {
        reservationService.removeEtudiantFromReservation(etudiantId, reservationId);
        return ResponseEntity.ok().build();
    }
}
