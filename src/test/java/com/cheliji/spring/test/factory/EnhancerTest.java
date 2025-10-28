package com.cheliji.spring.test.factory;

import com.cheliji.spring.test.factory.pojo.Dog;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;

public class EnhancerTest {

    @Test
    public void testEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback((MethodInterceptor)(obj, method, args, proxy) -> {
            System.out.println("叫之前");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("叫之后");
            return result ;

        });
        Dog dog = (Dog) enhancer.create();
        dog.shout() ;
    }

}
