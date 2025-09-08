package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.TicketStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class Ticket {
    Long id;
    Vehicle vehicle;
    ParkingSpot spot;
    TicketStatus status;
    Instant entryTime;
    Instant exitTime;
    BigDecimal fee;
}
