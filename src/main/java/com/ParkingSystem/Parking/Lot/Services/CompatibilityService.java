package com.ParkingSystem.Parking.Lot.Services;

import com.ParkingSystem.Parking.Lot.Enum.SpotType;
import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class CompatibilityService {

    private static  final Map<VehicleType , Set<SpotType>> ALLOWED =
            Map.of(
                    VehicleType.MOTORCYCLE, Set.of(SpotType.BIKE, SpotType.COMPACT, SpotType.REGULAR),
                    VehicleType.CAR, Set.of(SpotType.COMPACT, SpotType.REGULAR),
                    VehicleType.TRUCK, Set.of(SpotType.LARGE)
            );

    // Check if a vehicle can fit in a given spot type
    public boolean canFit(VehicleType v , SpotType s){
        return ALLOWED.getOrDefault(v , Set.of()).contains(s);
    }

    // Return all spot types that are valid for this vehicle type
    public Set<SpotType> allowed(VehicleType v){
        return ALLOWED.getOrDefault(v , Set.of());
    }

}
