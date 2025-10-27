package com.cheliji.spring.beans.factory.config;


/**
 * 用于获取单例 Bean
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例 Bean
     */
    Object getSingleton(String beanName);

}
