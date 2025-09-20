package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepo extends JpaRepository<ParkingLot,Long> {
}
