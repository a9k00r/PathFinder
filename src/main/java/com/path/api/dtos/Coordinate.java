package com.path.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coordinate {
    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lng")
    private double longitude;
}
