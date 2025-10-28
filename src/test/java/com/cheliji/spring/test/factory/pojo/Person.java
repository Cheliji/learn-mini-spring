package com.cheliji.spring.test.factory.pojo;

public class Person {

    private String name;

    private Dog dog ;



    public void sayHello () {
        System.out.println("hello");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
