package com.ParkingSystem.Parking.Lot.DTOs;

import com.ParkingSystem.Parking.Lot.Enum.VehicleType;



public record EntryRequest(String plate, VehicleType vehicleType) {}


