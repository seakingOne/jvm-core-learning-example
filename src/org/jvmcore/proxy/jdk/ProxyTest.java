package com.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Auther: 018399
 * @Date: 2018/11/12 13:51
 * @Description:jdk的动态代理，
 * 通过反射的思想，但是对于方法是static修饰的
 * 或者多个方法嵌套在一起会发现只有一个代理方法
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        CustomInvocationHandler handler = new CustomInvocationHandler(new HelloWorldImpl());
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{HelloWorld.class},
                handler);
        proxy.sayHello("Mikan");
    }
}
