package com.ParkingSystem.Parking.Lot.BootStrapData;

import com.ParkingSystem.Parking.Lot.Enum.SpotStatus;
import com.ParkingSystem.Parking.Lot.Enum.SpotType;
import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import com.ParkingSystem.Parking.Lot.Model.Level;
import com.ParkingSystem.Parking.Lot.Model.ParkingLot;
import com.ParkingSystem.Parking.Lot.Model.ParkingSpot;
import com.ParkingSystem.Parking.Lot.Model.RateCard;
import com.ParkingSystem.Parking.Lot.Repositories.LevelRepo;
import com.ParkingSystem.Parking.Lot.Repositories.ParkingLotRepo;
import com.ParkingSystem.Parking.Lot.Repositories.ParkingSpotRepository;
import com.ParkingSystem.Parking.Lot.Repositories.RateCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Component

public class DataBootStrap implements CommandLineRunner {

    private final RateCardRepository rateCardRepo;
    private final ParkingLotRepo parkingLotRepo;
    private final LevelRepo levelRepo;
    private final ParkingSpotRepository parkingSpotRepo;

    public DataBootStrap(RateCardRepository rateCardRepo, ParkingLotRepo parkingLotRepo, LevelRepo levelRepo, ParkingSpotRepository parkingSpotRepo) {
        this.rateCardRepo = rateCardRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.levelRepo = levelRepo;
        this.parkingSpotRepo = parkingSpotRepo;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // RATECARD
        rateCardRepo.save(
                new RateCard(
                        VehicleType.MOTORCYCLE,
                        BigDecimal.valueOf(20),
                        15,
                        BigDecimal.valueOf(150)));

        rateCardRepo.save(
                new RateCard(
                        VehicleType.CAR,
                        BigDecimal.valueOf(40),
                        15,
                        BigDecimal.valueOf(300)));

        rateCardRepo.save(
                new RateCard(
                        VehicleType.TRUCK,
                        BigDecimal.valueOf(80),
                        10,
                        BigDecimal.valueOf(150))
        );


        // --- Parking lot ---

//        List<ParkingLot> lot = List.of(
//                new ParkingLot("Central Mall", "Delhi"),
//                new ParkingLot("Big Bazzar", "Noida")
//        );
//        lot.forEach(parkingLotRepo::save);



        // --- Parking lot ---
        ParkingLot lot = new ParkingLot();
        lot.setName("Central Parkade");
        lot.setAddress("MG Road");
        parkingLotRepo.save(lot);

        // --- Levels ---
        Level l1 = new Level();
        l1.setName("L1");
        l1.setFloor("1");
        l1.setLot(lot);
        levelRepo.save(l1);

        Level l2 = new Level();
        l2.setName("L2");
        l2.setFloor("2");
        l2.setLot(lot);
        levelRepo.save(l2);


        // --- Spot types and counts for L1 ---
        Map<SpotType, Integer> spotCounts = Map.of(
                SpotType.BIKE, 10,
                SpotType.COMPACT, 20,
                SpotType.REGULAR, 20,
                SpotType.LARGE, 10
        );

        spotCounts.forEach((type, count) ->
                IntStream.rangeClosed(1, count).forEach(n -> {
                    ParkingSpot spot = new ParkingSpot();
                    spot.setCode("L1-" + type.name().charAt(0) + "-" + n); // e.g., L1-B-1
                    spot.setSpotType(type);
                    spot.setSpotStatus(SpotStatus.AVAILABLE);
                    spot.setLevel(l1); // associate with Level 1
                    parkingSpotRepo.save(spot);
                })
        );



        System.out.println("Bootstrapped parking lot data successfully!");


    }
}
