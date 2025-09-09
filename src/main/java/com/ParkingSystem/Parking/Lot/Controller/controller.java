package com.ParkingSystem.Parking.Lot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String message(){
        return "Appliction is working";
    }
}





