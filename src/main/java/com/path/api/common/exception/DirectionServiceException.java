package com.path.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DirectionServiceException extends RuntimeException{
    private String errorMessage;
}
