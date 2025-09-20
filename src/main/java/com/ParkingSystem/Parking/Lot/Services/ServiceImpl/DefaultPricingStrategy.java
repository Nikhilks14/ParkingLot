package com.ParkingSystem.Parking.Lot.Services.ServiceImpl;

import com.ParkingSystem.Parking.Lot.Model.PriceRule;
import com.ParkingSystem.Parking.Lot.Model.RateCard;
import com.ParkingSystem.Parking.Lot.Model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service   // ✅ registers as a Spring bean
public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal price(Ticket ticket, Instant at, RateCard card, List<PriceRule> rules) {
        Instant entryTime = ticket.getEntryTime();

        // Duration parked
        long totalMinutes = Duration.between(entryTime, at).toMinutes();

        // Apply grace minutes
        if (totalMinutes <= card.getGraceMintes()) {
            return BigDecimal.ZERO;
        }

        // Calculate hours (round up to next full hour)
        long hours = (totalMinutes + 59) / 60;

        // Base price
        BigDecimal base = card.getBasePerHour().multiply(BigDecimal.valueOf(hours));

        // Apply daily cap
        BigDecimal dailyCap = card.getDailyCap();
        if (dailyCap != null && base.compareTo(dailyCap) > 0) {
            base = dailyCap;
        }

        // Apply additional rules (surcharge/discount)
        for (PriceRule rule : rules) {
            base = rule.apply(base);
        }

        return base;
    }
}
