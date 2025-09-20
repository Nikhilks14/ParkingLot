package com.ParkingSystem.Parking.Lot.Services;

import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;
import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import com.ParkingSystem.Parking.Lot.Model.Ticket;
import com.ParkingSystem.Parking.Lot.Model.Vehicle;
import com.ParkingSystem.Parking.Lot.Repositories.TicketRepository;
import com.ParkingSystem.Parking.Lot.Repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TicketService {
    private final VehicleRepository vehRepo;
    private final TicketRepository ticketRepo;
    private final AllocationService alloc;

    public TicketService(VehicleRepository vehRepo, TicketRepository ticketRepo, AllocationService alloc) {
        this.vehRepo = vehRepo;
        this.ticketRepo = ticketRepo;
        this.alloc = alloc;
    }


    @Transactional
    public Ticket createEntry(String plate, VehicleType type){
        var vehicle = vehRepo.findByPlate(plate).orElseGet(() -> vehRepo.save(new Vehicle(null, plate, type, null, null)));
        var spot = alloc.allocate(type);
        var t = new Ticket();
        t.setVehicle(vehicle);
        t.setSpot(spot); t.setStatus(TicketStatus.OPEN); t.setEntryTime(Instant.now());
        return ticketRepo.save(t);
    }
}
