package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: 018399
 * @Date: 2018/11/12 13:50
 * @Description:
 */
public class CustomInvocationHandler implements InvocationHandler {

    private Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Before invocation");
        Object retVal = method.invoke(target, args);
        System.out.println("当前的代理对象为:" + target);
        System.out.println("当前的代理方法为:" + method.getName());
        System.out.println("After invocation");
        return retVal;
    }
}
