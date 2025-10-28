package com.cheliji.spring.test.factory;

import com.cheliji.spring.beans.PropertyValue;
import com.cheliji.spring.beans.PropertyValues;
import com.cheliji.spring.beans.factory.config.BeanDefinition;
import com.cheliji.spring.beans.factory.config.BeanReference;
import com.cheliji.spring.beans.factory.support.DefaultListableBeanFactory;
import com.cheliji.spring.test.factory.pojo.Dog;
import com.cheliji.spring.test.factory.pojo.Person;
import org.junit.Test;

public class BeanReferenceTest {

    @Test
    public void testBeanReference() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册 Dog Bean
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue name = new PropertyValue("name", "taidy");
        PropertyValue age = new PropertyValue("color", "yellow");
        propertyValues.addPropertyValue(name);
        propertyValues.addPropertyValue(age);

        BeanDefinition dogDefinition = new BeanDefinition(Dog.class,propertyValues) ;
        beanFactory.registerBeanDefinition("dog", dogDefinition);

        // 注册 Person
        PropertyValues propertyValues1 = new PropertyValues();
        PropertyValue name1 = new PropertyValue("name", "zhangsan");
        PropertyValue dog = new PropertyValue("dog",new BeanReference("dog")) ;

        propertyValues1.addPropertyValue(name1);
        propertyValues1.addPropertyValue(dog);

        BeanDefinition personDefinition = new BeanDefinition(Person.class,propertyValues1) ;

        beanFactory.registerBeanDefinition("person", personDefinition);

        Person person = (Person) beanFactory.getBean("person") ;

        System.out.println(person);



    }

}
