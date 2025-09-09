package com.ParkingSystem.Parking.Lot.DTOs;

import com.ParkingSystem.Parking.Lot.Enum.PaymentStatus;

import java.math.BigDecimal;

public record ExitResponse(Long paymentId, BigDecimal amount, PaymentStatus status) {}
