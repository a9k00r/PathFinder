package com.path.api.services;

import com.path.api.common.configs.GoogleApiConfig;
import com.path.api.common.utils.DistanceUtil;
import com.path.api.dtos.Coordinate;
import com.path.api.dtos.requests.RequestCoordinates;
import com.path.api.dtos.responses.DirectionsResponse;
import com.path.api.integration.GoogleApiConsumerService;
import io.leonard.PolylineUtils;
import io.leonard.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PathService {
    @Autowired
    private GoogleApiConsumerService googleApiConsumerService;
    @Autowired
    private GoogleApiConfig apiConfig;

    public List<Coordinate> getPathPlot(RequestCoordinates coordinates) {
        List<Coordinate> plotList = new ArrayList<>();
        double max = Double.MIN_VALUE;
        try {
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("mode", "driving");
            queryParams.put("origin", coordinates.getSource().getLatitude() + "," + coordinates.getSource().getLongitude());
            queryParams.put("destination", coordinates.getDestination().getLatitude() + "," + coordinates.getDestination().getLongitude());
            queryParams.put("key", apiConfig.getKey());

            DirectionsResponse response = googleApiConsumerService.getDirectionDate(queryParams);

            List<Position> points = PolylineUtils.decode(response.getRoutes().get(0).getOverviewPolyline().get("points"), 5);

            for (int i = 0; i < points.size() - 1; i++) {
                Coordinate first = new Coordinate(points.get(i).getLatitude(), points.get(i).getLongitude());
                Coordinate last = new Coordinate(points.get(i + 1).getLatitude(), points.get(i + 1).getLongitude());
                if (DistanceUtil.getDistance(first, last) > max)
                    max = DistanceUtil.getDistance(first, last);
            }

            int j = 0;
            while (j < points.size()) {
                Coordinate current = new Coordinate(points.get(j).getLatitude(), points.get(j).getLongitude());
                plotList.add(current);
                j = findPointAtDistance(points, j, max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plotList;
    }

    private int findPointAtDistance(List<Position> points, int currentIndex, double distance) {
        int i = currentIndex + 1;
        Coordinate source = Coordinate.builder().latitude(points.get(currentIndex).getLatitude()).latitude(points.get(currentIndex).getLongitude()).build();
        while (i < points.size() && DistanceUtil.getDistance(source, Coordinate.builder().latitude(points.get(i).getLatitude()).latitude(points.get(i).getLongitude()).build()) < distance)
            i++;
        return i;
    }
}
