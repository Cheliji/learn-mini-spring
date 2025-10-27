package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;


/**
 * InstantiationStrategy 的简单实现
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {

        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
