package com.cheliji.spring.beans.factory;

import com.cheliji.spring.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
