package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.SpotStatus;
import com.ParkingSystem.Parking.Lot.Enum.SpotType;

public class ParkingSpot {
    Long id;
    String code;
    SpotType spotType;
    SpotStatus spotStatus;
    Level level;
    // Long version;
}
