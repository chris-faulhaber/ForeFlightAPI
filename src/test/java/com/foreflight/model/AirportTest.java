package com.foreflight.model;

import com.foreflight.dao.AirportDAO;
import org.junit.Assert;
import org.junit.Test;

public class AirportTest {
    @Test
    public void TestDistance() {
        Airport pwm = AirportDAO.getAirportByID("KPWM");
        Airport hou = AirportDAO.getAirportByID("KHOU");
        Airport den = AirportDAO.getAirportByID("KDEN");

        Assert.assertEquals(2700, pwm.getDistanceFrom(hou.longitude, hou.latitude), 1);
        Assert.assertEquals(2860, pwm.getDistanceFrom(den.longitude, den.latitude), 1);
        Assert.assertEquals(1421, den.getDistanceFrom(hou.longitude, hou.latitude), 1);

    }
}
