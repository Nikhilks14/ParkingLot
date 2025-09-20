package com.ParkingSystem.Parking.Lot.Services;

import com.ParkingSystem.Parking.Lot.Model.Ticket;
import com.ParkingSystem.Parking.Lot.Repositories.PriceRuleRepository;
import com.ParkingSystem.Parking.Lot.Repositories.RateCardRepository;
import com.ParkingSystem.Parking.Lot.Services.ServiceImpl.PricingStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class PricingService {
    private final RateCardRepository cardRepo;
    private final PriceRuleRepository ruleRepo;
    private final PricingStrategy strategy;

    public PricingService(RateCardRepository cardRepo, PriceRuleRepository ruleRepo, PricingStrategy strategy) {
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.strategy = strategy;
    }

    public BigDecimal compute(Ticket t, Instant at){
        var card = cardRepo.findByVehicleType(t.getVehicle().getVehicleType()).orElseThrow();
        var rules = ruleRepo.findByRateCardIdOrderByFromMinuteAsc(card.getId());
        return strategy.price(t, at, card, rules);
    }
}
