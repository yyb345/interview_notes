package problems;

/**
 * 单例模式
 * Created by yangyibo
 * Date: 2019/4/2
 * Time: 下午5:05
 */
public class Singleton {
	//必须多线程可见
	private  volatile static Singleton singleton;

	private Singleton(){

	}

	//双重校验
	public  static Singleton getSingleton() {
		if(singleton==null){
			synchronized (Singleton.class){
				if(singleton==null)
					singleton=new Singleton();
			}
		}

		return singleton;
	}
}
