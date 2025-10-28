package com.cheliji.spring.test.factory;

import com.cheliji.spring.beans.PropertyValue;
import com.cheliji.spring.beans.PropertyValues;
import com.cheliji.spring.beans.factory.config.BeanDefinition;
import com.cheliji.spring.beans.factory.support.DefaultListableBeanFactory;
import com.cheliji.spring.test.factory.pojo.Dog;
import org.junit.Test;

public class PropertyValueTest {

    @Test
    public void testPropertyValue() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValue name = new PropertyValue("name", "taidy");
        PropertyValue color = new PropertyValue("color", "yellow");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(name);
        propertyValues.addPropertyValue(color);
        BeanDefinition beanDefinition = new BeanDefinition(Dog.class,propertyValues);

        beanFactory.registerBeanDefinition("dog", beanDefinition);
        Dog dog = (Dog) beanFactory.getBean("dog");
        System.out.println(dog);



    }

}
