package com.ParkingSystem.Parking.Lot.Services.ServiceImpl;

import com.ParkingSystem.Parking.Lot.Model.PriceRule;
import com.ParkingSystem.Parking.Lot.Model.RateCard;
import com.ParkingSystem.Parking.Lot.Model.Ticket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public interface PricingStrategy {
    BigDecimal price(
            Ticket ticket,
            Instant at,
            RateCard card,
            List<PriceRule> rules
    );
}
