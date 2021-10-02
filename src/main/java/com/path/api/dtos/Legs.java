package com.path.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Legs {
    private Map<String, String> distance;
    private Map<String, String> duration;

    @JsonProperty("end_address")
    private String endAddress;

    @JsonProperty("end_location")
    private Coordinate endLocation;

    @JsonProperty("start_address")
    private String startAddress;

    @JsonProperty("start_location")
    private Coordinate startLocation;

    private List<Steps> steps;

    @JsonProperty("traffic_speed_entry")
    private List<String> trafficSpeedEntry;

    @JsonProperty("via_waypoint")
    private List<String> viaWaypoint;
}
