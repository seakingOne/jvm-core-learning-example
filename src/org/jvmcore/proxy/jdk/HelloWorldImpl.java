package com.proxy.jdk;

/**
 * @Auther: 018399
 * @Date: 2018/11/12 13:49
 * @Description:
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
        sayHello1(name);
    }

    @Override
    public void sayHello1(String name) {
        System.out.println("Hello1 " + name);
    }
}
