package com.path.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bounds {
    private Coordinate northeast;
    private Coordinate southwest;
}
