package proxy.agent;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

public class CglibExample {

    public static void main(String[] args) {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(TargetClass.class);
        // 设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        // 创建代理对象
        TargetClass proxy = (TargetClass) enhancer.create();

        // 调用代理对象的方法
        proxy.sayHello();
    }
}

// 被代理的类
class TargetClass {
    public void sayHello() {
        System.out.println("Hello from TargetClass!");
    }
}

// MethodInterceptor的实现类
class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method invocation");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("After method invocation");
        return result;
    }
}

