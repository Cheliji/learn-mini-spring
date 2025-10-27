package com.cheliji.spring.beans.factory.support;

import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.factory.config.BeanDefinition;

/**
 * Bean 实例化策略接口
 *
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException ;

}
