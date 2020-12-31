package com.registrar;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanDefinitionRegistrar.class)
@EnableConfigurationProperties({PackageProperties.class})
public class StarterConfiguration
{
}