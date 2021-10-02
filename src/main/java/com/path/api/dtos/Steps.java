package com.path.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Steps {
    Map<String, String> distance;
    Map<String, String> duration;
    private Map<String, String> polyline;
    String maneuver;

    @JsonProperty("html_instructions")
    String htmlInstructions;

    @JsonProperty("travel_mode")
    String travelMode;

    @JsonProperty("end_location")
    Coordinate endLocation;

    @JsonProperty("start_location")
    Coordinate startLocation;
}
