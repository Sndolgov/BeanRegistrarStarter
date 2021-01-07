package com.registrar.flyRegistration;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

public class BeanOnFlyRegistrar
{
    @Autowired
    private CCL ccl;

    @Autowired
    private GenericApplicationContext context;

    @SneakyThrows
    public void regBean(BeanInfo beanInfo){
        Class<?> classType = ccl.findClass(beanInfo.getBeanClass());
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanDefinition.setBeanClass(classType);
        beanFactory.registerBeanDefinition(beanInfo.getBeanName(), beanDefinition);
        context.getBean(classType);
    }
}
