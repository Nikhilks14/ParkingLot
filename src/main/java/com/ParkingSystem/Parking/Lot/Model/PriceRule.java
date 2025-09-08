package com.ParkingSystem.Parking.Lot.Model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PriceRule {
    Long id;
    RateCard rateCard;
    Integer fromMinute;
    Integer toMinute;
    BigInteger flat;
    BigDecimal perHour;
}
