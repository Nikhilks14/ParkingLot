package com.ParkingSystem.Parking.Lot.Controller;

import com.ParkingSystem.Parking.Lot.DTOs.EntryRequest;
import com.ParkingSystem.Parking.Lot.DTOs.EntryResponse;
import com.ParkingSystem.Parking.Lot.Services.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    private final TicketService tickets;

    public EntryController(TicketService tickets) {
        this.tickets = tickets;
    }


    @PostMapping
    public EntryResponse enter(@RequestBody @Valid EntryRequest req){
        var t = tickets.createEntry(req.plate(), req.vehicleType());
        return new EntryResponse(t.getId(), t.getSpot().getCode(), t.getSpot().getSpotType(), t.getEntryTime());
    }
}