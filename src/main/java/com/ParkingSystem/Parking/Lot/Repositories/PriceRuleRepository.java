package com.ParkingSystem.Parking.Lot.Repositories;

import com.ParkingSystem.Parking.Lot.Model.PriceRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRuleRepository extends JpaRepository<PriceRule, Long> {
    List<PriceRule> findByRateCardIdOrderByFromMinuteAsc(Long rateCardId);
}
