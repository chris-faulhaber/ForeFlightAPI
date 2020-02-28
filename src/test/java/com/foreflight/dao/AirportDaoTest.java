package com.foreflight.dao;

import com.foreflight.model.Airport;
import org.junit.Assert;
import org.junit.Test;

public class AirportDaoTest {
    @Test
    public void TestGetClosestAirport() {
        Airport pwm = AirportDAO.getAirportByID("KPWM");
        Assert.assertEquals(pwm, AirportDAO.getClosestAirport(pwm.longitude, pwm.latitude));
    }

    @Test
    public void TestGetClosestNonAirport() {
        Airport pwm = AirportDAO.getAirportByID("KPWM");
        Assert.assertEquals(pwm, AirportDAO.getClosestAirport(-70, 40));

        Airport hou = AirportDAO.getAirportByID("KHOU");
        Assert.assertEquals(hou, AirportDAO.getClosestAirport(-90, 30));
    }
}

