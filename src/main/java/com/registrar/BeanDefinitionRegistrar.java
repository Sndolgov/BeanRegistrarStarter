package com.registrar;

import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.beans.Introspector;
import java.util.Set;

public class BeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware
{
    private Environment environment;
    private ScanProperties scanProperties = new ScanProperties();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry)
    {
        String packageName = environment.getProperty("scan.path");
        Reflections scanner = new Reflections(packageName);
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(Singleton.class, true);
        for (Class<?> classType : classes)
        {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(classType);
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            registry.registerBeanDefinition(Introspector.decapitalize(classType.getName()), beanDefinition);
        }

    }

    @Override
    public void setEnvironment(Environment environment)
    {
        this.environment = environment;
    }
}
