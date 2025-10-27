package com.cheliji.spring.beans.factory.config;

/**
 * Bean 的元数据，定义 Bean 的基本信息
 * 这里仅包含 class 类型
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

}
