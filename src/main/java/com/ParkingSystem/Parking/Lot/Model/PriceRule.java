package com.ParkingSystem.Parking.Lot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "price_rule")
@Getter
@Setter
public class PriceRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_card_id", nullable = false)
    private RateCard rateCard;

    private Integer fromMinute;
    private Integer toMinute;

    private BigDecimal flat;      // Changed from BigInteger to BigDecimal
    private BigDecimal perHour;   // Keep consistent with monetary values



    /**
     * Apply this rule to calculate price for given minutes.
     */
    public BigDecimal apply(BigDecimal minutes) {
        if (minutes.intValue() < fromMinute ||
                (toMinute != null && minutes.intValue() > toMinute)) {
            return BigDecimal.ZERO;
        }

        if (flat != null) {
            return flat;
        }

        if (perHour != null) {
            BigDecimal hours = minutes
                    .divide(BigDecimal.valueOf(60), 2, RoundingMode.CEILING);
            return perHour.multiply(hours);
        }

        return BigDecimal.ZERO;
    }

}
