package agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyHandler implements InvocationHandler {


    Object target;
    JdkProxyHandler(Object target){
        this.target= target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long currentTimeMillis = System.currentTimeMillis();

        Object invoke = method.invoke(this.target, args);

        System.out.println("invoke time "+(System.currentTimeMillis()-currentTimeMillis) +" ms");
        return invoke;
    }

    public static  void main(String[] args){


        ServiceMethod serviceMethod = new ServiceMethod();

        JdkProxyHandler jdkProxyHandler = new JdkProxyHandler(serviceMethod);
        Object oo = Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class}, jdkProxyHandler);

        Service xx= (Service)oo;
        xx.method1();


    }
}
