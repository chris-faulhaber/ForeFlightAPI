package com.foreflight.dao;


import com.foreflight.model.Airport;

import java.util.*;

public class AirportDAO {

    private static final Collection<Airport> airports;
    private static final HashMap<String, Airport> airportsById;

    static {
        airports = new ArrayList<>();
        airports.add(new Airport(1, "KPWM", "Portland Jetport", 43.6456435, -70.3086164));
        airports.add(new Airport(2, "KDEN", "Denver", 39.8616667, -104.6731667));
        airports.add(new Airport(3, "KORD", "Chicago", 41.9745206, -87.9065973));
        airports.add(new Airport(4, "KAUS", "Austin", 30.1945272, -97.6698761));
        airports.add(new Airport(5, "KHOU", "Houston", 29.6454167, -95.2788889));

        airportsById = new HashMap<>();
        // while loop
        for (Airport ap : airports) {
            airportsById.put(ap.id, ap);
        }
    }

    public static Airport getAirportByID(String id) {
        return airportsById.get(id);
    }

    public static List<Airport> getAirportsByIDs(List<String> ids) {
        Iterator<String> iterator = ids.iterator();

        List<Airport> resultSet = new ArrayList<>();
        while (iterator.hasNext()) {
            String id = iterator.next();
            Airport ap = airportsById.get(id);
            if (ap != null) {
                resultSet.add(ap);
            }
        }

        return resultSet;
    }

    public static Airport getClosestAirport(double lon, double lan) {
        Airport closest = getAirportByID("KPWM");
        double bestDistance = -1.0;

        for (Airport ap : airports) {
            double distanceFrom = ap.getDistanceFrom(lon, lan);

            if (bestDistance < 0 || bestDistance > distanceFrom) {
                bestDistance = distanceFrom;
                closest = ap;
            }
        }

        return closest;
    }
}
