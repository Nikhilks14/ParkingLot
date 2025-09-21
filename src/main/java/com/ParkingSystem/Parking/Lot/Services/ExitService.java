package com.ParkingSystem.Parking.Lot.Services;

import com.ParkingSystem.Parking.Lot.Enum.PaymentMethod;
import com.ParkingSystem.Parking.Lot.Enum.PaymentStatus;
import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;
import com.ParkingSystem.Parking.Lot.Model.Payment;
import com.ParkingSystem.Parking.Lot.Repositories.PaymentRepository;
import com.ParkingSystem.Parking.Lot.Repositories.TicketRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class ExitService {
    private final TicketRepository ticketRepo;
    private final AllocationService alloc;
    private final PricingService pricing;
    private final PaymentRepository payRepo;

    public ExitService(TicketRepository ticketRepo, AllocationService alloc, PricingService pricing, PaymentRepository payRepo) {
        this.ticketRepo = ticketRepo;
        this.alloc = alloc;
        this.pricing = pricing;
        this.payRepo = payRepo;
    }


    @Transactional
    public Payment settleByTicketId(Long ticketId, PaymentMethod method){
        var t = ticketRepo.findByIdAndStatus(ticketId, TicketStatus.OPEN).orElseThrow();
        var amount = pricing.compute(t, Instant.now());
        var p = new Payment(); p.setTicket(t); p.setStatus(PaymentStatus.PENDING);
        p.setMethod(method);
        p.setAmount(amount);
        p.setPaidAt(Instant.now());
        // simulate payment gateway success

        p.setStatus(PaymentStatus.SUCCESS); p = payRepo.save(p);
        t.setFee(amount); t.setExitTime(p.getPaidAt()); t.setStatus(TicketStatus.CLOSED);
        ticketRepo.save(t);
        alloc.release(t.getSpot().getId());
        return p;
    }
}