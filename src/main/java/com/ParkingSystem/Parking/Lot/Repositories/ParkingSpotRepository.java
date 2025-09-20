package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Enum.SpotType;
import com.ParkingSystem.Parking.Lot.Model.ParkingSpot;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Long> {

    @Lock(LockModeType.OPTIMISTIC)
    @Query("""
       select s from ParkingSpot s
       where s.spotStatus = com.ParkingSystem.Parking.Lot.Enum.SpotStatus.AVAILABLE
       and s.spotType in :types
       order by s.level.id asc, s.spotType asc
       """)
    List<ParkingSpot> findAvailableInTypes(@Param("types") Collection<SpotType> types);


}
