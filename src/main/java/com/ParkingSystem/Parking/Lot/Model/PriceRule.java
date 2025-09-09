package com.ParkingSystem.Parking.Lot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "price_rule")
@Getter
@Setter
public class PriceRule {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(fetch = FetchType.LAZY) RateCard rateCard;
    Integer fromMinute;
    Integer toMinute;
    BigInteger flat;
    BigDecimal perHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RateCard getRateCard() {
        return rateCard;
    }

    public void setRateCard(RateCard rateCard) {
        this.rateCard = rateCard;
    }

    public Integer getFromMinute() {
        return fromMinute;
    }

    public void setFromMinute(Integer fromMinute) {
        this.fromMinute = fromMinute;
    }

    public Integer getToMinute() {
        return toMinute;
    }

    public void setToMinute(Integer toMinute) {
        this.toMinute = toMinute;
    }

    public BigInteger getFlat() {
        return flat;
    }

    public void setFlat(BigInteger flat) {
        this.flat = flat;
    }

    public BigDecimal getPerHour() {
        return perHour;
    }

    public void setPerHour(BigDecimal perHour) {
        this.perHour = perHour;
    }
}
