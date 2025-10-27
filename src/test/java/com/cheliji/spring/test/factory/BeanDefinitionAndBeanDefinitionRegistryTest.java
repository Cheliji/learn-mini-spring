package com.cheliji.spring.test.factory;

import com.cheliji.spring.beans.factory.config.BeanDefinition;
import com.cheliji.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class BeanDefinitionAndBeanDefinitionRegistryTest {
    
    @Test
    public void TestDefaultListableBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(Person.class);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");

        person.sayHello();

    }
    
}
