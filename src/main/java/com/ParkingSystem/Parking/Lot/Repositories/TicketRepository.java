package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;
import com.ParkingSystem.Parking.Lot.Model.Ticket;

import java.util.Optional;

public interface TicketRepository {
    Optional<Ticket> findByIdAndStatus(Long id, TicketStatus status);
    Optional<Ticket> findFirstByVehiclePlateAndStatusOrderByEntryTimeDesc(String plate, TicketStatus status);
}






