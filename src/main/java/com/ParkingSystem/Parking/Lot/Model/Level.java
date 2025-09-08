package com.ParkingSystem.Parking.Lot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
    @Id @GeneratedValue
    Long id;
    String name;
    String floor;
}
