package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.PaymentMethod;
import com.ParkingSystem.Parking.Lot.Enum.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class Payment {
    Long id;
    Ticket ticket;
    PaymentStatus status;
    PaymentMethod method;
    BigDecimal amount;
    String reference;
    Instant paidAt;
}
