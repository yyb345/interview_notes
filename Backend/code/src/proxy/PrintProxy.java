package proxy;

/**
 * Created by yangyibo
 * Date: 2019/4/2
 * Time: 下午5:21
 */
public class PrintProxy implements Test {

	Test proxy;
	PrintProxy(Test test){
		this.proxy=test;

	}

	@Override
	public void printMessage(){
		proxy.printMessage();
	}


	public static void main(String[] args){
		new PrintProxy(new Print1()).printMessage();
		new PrintProxy(new Print2()).printMessage();
	}
}
