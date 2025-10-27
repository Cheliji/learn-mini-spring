package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
