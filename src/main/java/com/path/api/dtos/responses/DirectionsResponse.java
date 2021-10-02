package com.path.api.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.path.api.dtos.GeocodedWaypoints;
import com.path.api.dtos.Routes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DirectionsResponse {
    @JsonProperty("geocoded_waypoints")
    private List<GeocodedWaypoints> geocodedWaypoints;
    private List<Routes> routes;
    private String status;

}
