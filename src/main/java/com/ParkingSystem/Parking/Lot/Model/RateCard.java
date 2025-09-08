package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.VehicleType;

import java.math.BigDecimal;

public class RateCard {
    Long id;
    VehicleType vehicleType;
    BigDecimal basePerHour;
    Integer graceMintes;
    BigDecimal dailyCap;
}
