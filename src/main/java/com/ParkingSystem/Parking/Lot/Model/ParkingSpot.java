package com.ParkingSystem.Parking.Lot.Model;

import com.ParkingSystem.Parking.Lot.Enum.SpotStatus;
import com.ParkingSystem.Parking.Lot.Enum.SpotType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "parking_spot",
        indexes = {@Index(columnList = "spotStatus"),
                @Index(columnList = "spotType")})


public class ParkingSpot {
    @Id
    @GeneratedValue
    Long id; // eg L1-R12
    String code;
    @Enumerated(EnumType.STRING) SpotType spotType;
    @Enumerated(EnumType.STRING) SpotStatus spotStatus;
    @ManyToOne(fetch = FetchType.LAZY) Level level;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
