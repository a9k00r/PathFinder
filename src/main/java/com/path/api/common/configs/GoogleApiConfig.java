package com.path.api.common.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("com.path.api.services.google")
@Data
public class GoogleApiConfig {
    private String endpoint;
    private String key;
}
