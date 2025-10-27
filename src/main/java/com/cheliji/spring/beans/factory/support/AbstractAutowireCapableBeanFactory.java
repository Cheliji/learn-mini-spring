package com.cheliji.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.cheliji.spring.beans.BeansException;
import com.cheliji.spring.beans.PropertyValue;
import com.cheliji.spring.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName,beanDefinition) ;
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {

        Object bean = null ;

        try{
            bean = instantiationStrategy.instantiate(beanDefinition);

            // 为 bean 添加属性值
            //为bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed",e) ;
        }

        addSingleton(beanName, bean) ;

        return bean ;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String propertyName = propertyValue.getName();
                Object value = propertyValue.getValue();

                BeanUtil.setFieldValue(bean,propertyName,value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values for bean: " + beanName,e) ;
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
