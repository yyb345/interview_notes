package classloader;

/**
 * Created by yangyibo
 * Date: 2019/6/8
 * Time: 下午8:50
 * 这个类是用来测试类加载时机的，下面这个例子证明了被动引用类加载的时机
 */



class SuperClass {
	static {
		System.out.println("superclass init");
	}
	public static int value = 123;
}

class SubClass extends SuperClass {
	static {
		System.out.println("subclass init");
	}
}

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(SubClass.value);// 被动应用1
		SubClass[] sca = new SubClass[10];// 被动引用2
	}
}



