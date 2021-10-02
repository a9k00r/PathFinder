package com.path.api.common.utils;

import com.path.api.dtos.Coordinate;
import org.springframework.stereotype.Component;

@Component
public class DistanceUtil {
    private DistanceUtil() {
    }

    public static double getDistance(Coordinate x, Coordinate y) {
        if (x.getLatitude() == y.getLatitude() && x.getLongitude() == y.getLongitude()) {
            return 0;
        } else {
            double theta = x.getLongitude() - y.getLongitude();
            double distance = Math.sin(Math.toRadians(x.getLatitude())) * Math.sin(Math.toRadians(y.getLatitude()))
                    + Math.cos(Math.toRadians(x.getLatitude())) * Math.cos(Math.toRadians(y.getLatitude()))
                    * Math.cos(Math.toRadians(theta));

            return Math.abs(Math.toDegrees(Math.acos(distance)) * 60 * 1.1515 * 1.609344 * 1000);
        }
    }
}
