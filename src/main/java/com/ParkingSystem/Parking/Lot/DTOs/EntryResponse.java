package com.ParkingSystem.Parking.Lot.DTOs;

import com.ParkingSystem.Parking.Lot.Enum.SpotType;

import java.time.Instant;

public record EntryResponse(Long ticketId, String spotCode, SpotType spotType, Instant entryTime) {}