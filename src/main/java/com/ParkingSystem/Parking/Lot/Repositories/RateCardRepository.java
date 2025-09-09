package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import com.ParkingSystem.Parking.Lot.Model.RateCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RateCardRepository extends JpaRepository<RateCard, Long> {
    Optional<RateCard> findByVehicleType(VehicleType type);
}