package com.foreflight.model;

public class Airport {
    public long key;
    public String id;
    public String name;
    public Double latitude;
    public Double longitude;

    public Airport(long key, String id, String name, Double latitude, Double longitude) {
        this.key = key;
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistanceFrom(double lon, double lat) {
        double lon1 = Math.toRadians(lon);
        double lon2 = Math.toRadians(this.longitude);
        double lat1 = Math.toRadians(lat);
        double lat2 = Math.toRadians(this.latitude);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers.
        double r = 6371;
        return (c * r);
    }
}
