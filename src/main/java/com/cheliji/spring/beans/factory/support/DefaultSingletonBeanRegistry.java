package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * SingletonBeanRegistry 的实现类，用于存储单例 Bean
 * 将单例 Bean 存储在 singletonMap 之中
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonMap = new HashMap<>() ;

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    public void addSingleton(String beanName, Object singleton) {
        singletonMap.put(beanName, singleton);
    }
}
