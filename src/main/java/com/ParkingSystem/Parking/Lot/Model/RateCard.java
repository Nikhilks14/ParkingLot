package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "rate_card")
@NoArgsConstructor
public class RateCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    VehicleType vehicleType;
    BigDecimal basePerHour;
    Integer graceMintes;
    BigDecimal dailyCap;

    public RateCard(VehicleType vehicleType, BigDecimal basePerHour, Integer graceMintes, BigDecimal dailyCap) {
        this.vehicleType = vehicleType;
        this.basePerHour = basePerHour;
        this.graceMintes = graceMintes;
        this.dailyCap = dailyCap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BigDecimal getBasePerHour() {
        return basePerHour;
    }

    public void setBasePerHour(BigDecimal basePerHour) {
        this.basePerHour = basePerHour;
    }

    public Integer getGraceMintes() {
        return graceMintes;
    }

    public void setGraceMintes(Integer graceMintes) {
        this.graceMintes = graceMintes;
    }

    public BigDecimal getDailyCap() {
        return dailyCap;
    }

    public void setDailyCap(BigDecimal dailyCap) {
        this.dailyCap = dailyCap;
    }
}
