package com.proxy.javassist;

import com.test.netty.client.Client;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Auther: 018399
 * @Date: 2018/11/12 10:50
 * @Description:通过字节码来实现代理对象，免去了反射的过程，能提高效率
 */
public class JavassistProxyFactory {
    /*
     * 要代理的对象的class
     * */
    @SuppressWarnings("deprecation")
    public static Object getProxy(Class clazz) throws InstantiationException, IllegalAccessException {
        // 代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置需要创建子类的父类
        proxyFactory.setSuperclass(clazz);
        /*
         * 定义一个拦截器。在调用目标方法时，Javassist会回调MethodHandler接口方法拦截，
         * 来实现你自己的代理逻辑，
         * 类似于JDK中的InvocationHandler接口。
         */
        proxyFactory.setHandler(new MethodHandler() {
            /*
             * self为由Javassist动态生成的代理类实例，
             * this method为 当前要调用的方法
             * proceed 为生成的代理类对方法的代理引用。
             * Object[]为参数值列表，
             * 返回：从代理实例的方法调用返回的值。
             *
             * 其中，proceed.invoke(self, args);
             *
             * 调用代理类实例上的代理方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
             */
            public Object invoke(Object self, Method thismethod, Method proceed, Object[] args) throws Throwable {
                System.out.println("代理类为：" + self.getClass());
                //class com.proxy.javassist.demo.A_$$_javassist_0
                System.out.println("代理类对方法的代理引用:"+thismethod.getName());

                System.out.println("------该方法中加入额外的处理操作------");

                System.out.println("-------开启事务-------");

                Object result = proceed.invoke(self, args);

                System.out.println("-------提交事务-------");
                return result;
            }
        });

        // 通过字节码技术动态创建子类实例
        return  proxyFactory.createClass().newInstance();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Client client = new Client();
        Client proxy = (Client)JavassistProxyFactory.getProxy(client.getClass());
        proxy.test("ynhuang");

    }

}
