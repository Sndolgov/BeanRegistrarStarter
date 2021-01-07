package com.registrar.flyRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanInfo
{
    private String beanName;
    private String beanClass;


    public void setBeanName(String beanName)
    {
        this.beanName = beanName;
    }

    public void setBeanClass(String beanClass)
    {
        this.beanClass = beanClass;
    }
}
