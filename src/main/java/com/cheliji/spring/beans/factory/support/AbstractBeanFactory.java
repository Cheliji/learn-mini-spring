package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.factory.BeanFactory;
import com.cheliji.spring.beans.factory.config.BeanDefinition;

/**
 * 分别继承和实现了 DefaultSingletonBeanRegistry 、 BeanFactory
 * 重写 BeanFactory 中的 getBean 方法，
 * 同时使用模板方法，将获取 BeanDefinition 和创建 Bean 延迟到子类实现
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {



    @Override
    public Object getBean(String name) throws BeansException {

        Object bean = getSingleton(name) ;

        if (bean != null) {
            return bean ;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name) ;
        return createBean(name,beanDefinition) ;


    }

    protected abstract BeanDefinition getBeanDefinition(String name) ;

    protected abstract Object createBean(String name,BeanDefinition beanDefinition) ;


}
