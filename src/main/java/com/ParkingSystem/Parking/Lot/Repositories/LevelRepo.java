package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Model.Level;
import com.ParkingSystem.Parking.Lot.Model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepo extends JpaRepository<Level,Long> {
}
