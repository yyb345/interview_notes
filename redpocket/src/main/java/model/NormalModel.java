package model;

/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午7:34
 * 普通红包(线程安全)
 */
public class NormalModel implements PlayModel {

	public static final double MAX_MONEY=200;
	private  volatile Integer num;
	private  double money;

	public NormalModel(int n,double money) throws Exception{
		if(n<1){
			throw new Exception("红包个数不能小于1");
		}

		if(money>MAX_MONEY){
			throw new Exception("单个红包不得大于 "+MAX_MONEY);
		}
		num=n;
		this.money=money;
	}

	public double generate() throws Exception {
		synchronized (num){
			if(num>0){
				num--;
				return this.money;
			}else{
				return 0.0;
			}
		}


	}
}
