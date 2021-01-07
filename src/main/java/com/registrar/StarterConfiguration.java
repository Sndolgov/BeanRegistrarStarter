package com.registrar;

import com.registrar.annotationRegistration.BeanDefinitionRegistrar;
import com.registrar.flyRegistration.BeanOnFlyRegistrar;
import com.registrar.flyRegistration.CCL;
import com.registrar.property.ScanProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanDefinitionRegistrar.class)
@EnableConfigurationProperties({ScanProperties.class})
public class StarterConfiguration
{
    @Bean
    public CCL getCustomClassLoader(){
        return new CCL();
    }

    @Bean
    public BeanOnFlyRegistrar getBeanOnFlyRegistrar(){
        return new BeanOnFlyRegistrar();
    }
}
