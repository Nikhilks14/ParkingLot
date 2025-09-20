package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;
import com.ParkingSystem.Parking.Lot.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Optional<Ticket> findByIdAndStatus(Long id, TicketStatus status);
    Optional<Ticket> findFirstByVehiclePlateAndStatusOrderByEntryTimeDesc(String plate, TicketStatus status);

    Ticket save(Ticket t);
}






