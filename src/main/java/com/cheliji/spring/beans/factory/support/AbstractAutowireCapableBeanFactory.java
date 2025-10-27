package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private SimpleInstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName,beanDefinition) ;
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {

        Object bean = null ;

        try{
            bean = instantiationStrategy.instantiate(beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed",e) ;
        }

        addSingleton(beanName, bean) ;

        return bean ;
    }
}
