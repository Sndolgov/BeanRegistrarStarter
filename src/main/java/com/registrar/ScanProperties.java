package com.registrar;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "scan")
public class ScanProperties
{
    private String path;
}
