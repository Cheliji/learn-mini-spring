package com.cheliji.spring.test.factory;

public class Dog {



    private String name ;

    private String color ;

    public void shout() {
        System.out.println("wangwang");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
