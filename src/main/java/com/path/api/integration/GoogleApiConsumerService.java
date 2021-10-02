package com.path.api.integration;

import com.path.api.common.configs.GoogleApiConfig;
import com.path.api.dtos.responses.DirectionsResponse;
import com.path.api.common.exception.DirectionServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;

@Service
public class GoogleApiConsumerService {

    @Autowired
    private GoogleApiConfig apiConfig;
    @Autowired
    private RestTemplate restTemplate;

    public DirectionsResponse getDirectionDate(Map<String, Object> orderQueryParams) throws DirectionServiceException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<DirectionsResponse> entity = new HttpEntity<>(headers);
        String url = apiConfig.getEndpoint();
        UriComponentsBuilder queryParamsBuilder = UriComponentsBuilder.fromHttpUrl(url);

        for (Map.Entry<String, Object> param : orderQueryParams.entrySet()) {
            queryParamsBuilder.queryParam(param.getKey(), param.getValue());
        }
        String urlWithParams = queryParamsBuilder.toUriString();
        try {
            return restTemplate.exchange(urlWithParams, HttpMethod.GET, entity, DirectionsResponse.class).getBody();
        } catch (Exception ex) {
            throw new DirectionServiceException(ex.getMessage());
        }
    }

}

