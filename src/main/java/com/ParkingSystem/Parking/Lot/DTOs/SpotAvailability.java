package com.ParkingSystem.Parking.Lot.DTOs;

import com.ParkingSystem.Parking.Lot.Enum.SpotType;

import java.util.Map;

public record SpotAvailability(Long total, Long available, Map<SpotType, Long> byType) {}
