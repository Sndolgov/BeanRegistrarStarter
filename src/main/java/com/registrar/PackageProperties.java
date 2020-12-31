package com.registrar;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "package")
public class PackageProperties
{
    private String path;
}
