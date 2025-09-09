package com.ParkingSystem.Parking.Lot.Controller;

import com.ParkingSystem.Parking.Lot.DTOs.ExitRequest;
import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;
import com.ParkingSystem.Parking.Lot.Services.ExitService;
import com.ParkingSystem.Parking.Lot.Services.PricingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ParkingSystem.Parking.Lot.Repositories.TicketRepository;

import com.ParkingSystem.Parking.Lot.DTOs.ExitResponse;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
@RequestMapping("/api/exits")
@RequiredArgsConstructor
public class ExitController {
    private final ExitService exits;
    private final TicketRepository ticketRepo;
    private final PricingService pricing;

    public ExitController(ExitService exits, TicketRepository ticketRepo, PricingService pricing) {
        this.exits = exits;
        this.ticketRepo = ticketRepo;
        this.pricing = pricing;
    }

    @PostMapping
    public ExitResponse exit(@RequestBody @Valid ExitRequest req){
        var payment = exits.settleByTicketId(req.ticketId(), req.method());
        return new ExitResponse(payment.getId(), payment.getAmount(), payment.getStatus());
    }
    @GetMapping("/quote/{ticketId}") public BigDecimal quote(@PathVariable Long ticketId){
        var t = ticketRepo.findByIdAndStatus(ticketId, TicketStatus.OPEN).orElseThrow();
        return pricing.compute(t, Instant.now());
    }
}

