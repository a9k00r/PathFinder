package com.path.api.controllers;

import com.path.api.common.constants.ApiConstants;
import com.path.api.dtos.Coordinate;
import com.path.api.dtos.requests.RequestCoordinates;
import com.path.api.services.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DirectionController {
    @Autowired
    private PathService pathService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ApiConstants.path, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Coordinate>> retrieveOrderList(HttpServletRequest servletRequest,
                                                              @RequestBody RequestCoordinates requestCoordinates) {

        List<Coordinate> coordinates = pathService.getPathPlot(requestCoordinates);
        servletRequest.setAttribute("ResponseBody", coordinates);
        return ResponseEntity.ok().body(coordinates);
    }

}
