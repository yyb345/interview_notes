package classloader;

/**
 * Created by yangyibo
 * Date: 2019/6/8
 * Time: 下午9:47
 *
 * 这个类主要证明了类初始化 类变量的时候，是按照代码的先后顺序进行初始化的，
 * 先初始化sigleTon，count2先被初始化为0，再调用count2++，然后再初始化 赋值操作 count2=0
 *
 */
class SingleTon {

	private static SingleTon singleTon = new SingleTon();
	public static int count1;
	public static int count2=0;

	private SingleTon() {
		count1++;
		count2++;
	}

	public static SingleTon getInstance() {
		return singleTon;
	}
}

public class ClassInitTest {
	public static void main(String[] args) {
		SingleTon singleTon = SingleTon.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);

		//ConcurrentSkipListMap


	}
}

