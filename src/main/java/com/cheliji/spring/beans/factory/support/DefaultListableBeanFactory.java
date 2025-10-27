package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.factory.config.BeanDefinition;
import org.aspectj.weaver.loadtime.definition.Definition;

import java.util.HashMap;
import java.util.Map;

/**
 * 分别继承和实现了 AbstractAutowireCapableBeanFactory 、 BeanDefinitionRegistry
 *
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap();

    /**
     * 用于注册 Bean Definition 信息
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 实现抽象类中的 getBeanDefinition 方法
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined") ;
        }

        return beanDefinition ;
    }
}
