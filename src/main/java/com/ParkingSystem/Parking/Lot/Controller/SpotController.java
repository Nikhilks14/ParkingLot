package com.ParkingSystem.Parking.Lot.Controller;

import com.ParkingSystem.Parking.Lot.DTOs.SpotAvailability;
import com.ParkingSystem.Parking.Lot.Enum.SpotType;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/spots") @RequiredArgsConstructor
public class SpotController {
    private final EntityManager em;

    public SpotController(EntityManager em) {
        this.em = em;
    }

    @GetMapping("/availability") public SpotAvailability availability(){
        Long total = em.createQuery("select count(s) from ParkingSpot s", Long.class).getSingleResult();
        Long available = em.createQuery("select count(s) from ParkingSpot s where s.status='AVAILABLE'", Long.class).getSingleResult();
        List<Object[]> rows = em.createQuery("select s.spotType, count(s) from ParkingSpot s where s.status='AVAILABLE' group by s.spotType", Object[].class).getResultList();
        Map<SpotType, Long> byType = rows.stream().collect(Collectors.toMap(r -> (SpotType) r[0], r -> (Long) r[1]));
        return new SpotAvailability(total, available, byType);
    }
}
