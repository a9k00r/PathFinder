package com.path.api.dtos.requests;

import com.path.api.dtos.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCoordinates {
    Coordinate source;
    Coordinate destination;
}
