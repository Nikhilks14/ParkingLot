package com.ParkingSystem.Parking.Lot.DTOs;

import com.ParkingSystem.Parking.Lot.Enum.PaymentMethod;

public record ExitRequest(Long ticketId, PaymentMethod method) {}
