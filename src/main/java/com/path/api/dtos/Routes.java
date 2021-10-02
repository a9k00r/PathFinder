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
public class Routes {
    private Bounds bounds;
    private String copyrights;
    private List<Legs> legs;
    private String summary;
    private List<String> warnings;

    @JsonProperty("overview_polyline")
    private Map<String, String> overviewPolyline;

    @JsonProperty("waypoint_order")
    private List<String> waypointOrder;
}
