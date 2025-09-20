package com.ParkingSystem.Parking.Lot.Services;

import com.ParkingSystem.Parking.Lot.Enum.SpotStatus;
import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import com.ParkingSystem.Parking.Lot.Model.ParkingSpot;
import com.ParkingSystem.Parking.Lot.Repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class AllocationService {
    private final ParkingSpotRepository spotRepo;
    private final CompatibilityService compat;

    public AllocationService(ParkingSpotRepository spotRepo, CompatibilityService compat) {
        this.spotRepo = spotRepo;
        this.compat = compat;
    }

    @Transactional
    public ParkingSpot allocate(VehicleType type){
        var allowed = compat.allowed(type);
        var spots = spotRepo.findAvailableInTypes(allowed);
        for (ParkingSpot s : spots){
            s.setSpotStatus(SpotStatus.OCCUPIED); // optimistic @Version prevents double take
            return spotRepo.save(s);
        }
        throw new NoSuchElementException("No compatible spots available");
    }
    @Transactional public void release(Long spotId){
        var s = spotRepo.findById(spotId).orElseThrow(); s.setSpotStatus(SpotStatus.AVAILABLE); spotRepo.save(s);
    }
}





