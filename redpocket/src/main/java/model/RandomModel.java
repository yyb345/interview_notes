package model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午5:34
 * 拼手气红包
 */
public class RandomModel implements PlayModel{


	/**
	 * 红包个数
	 */
	private AtomicInteger num;
	/**
	 * 红包总额
	 */
	private volatile Double totalMoney;

	/**
	 * 每人拿到的最小值
	 */
	public static final double MIN_MONEY=0.01;



	public RandomModel(int n,Double totalMoney) throws Exception {

		if(n<1){
			throw new Exception(" 红包个数不能小于1");
		}

		if(totalMoney<(n*MIN_MONEY)){
			throw new Exception(" 单个红包至少分到 "+ MIN_MONEY);
		}


		this.num=new AtomicInteger(n);
		this.totalMoney=totalMoney;
	}


	public double generate() throws Exception {

		synchronized (totalMoney){
			if(num.get()==0){
				return 0.0;
			}
			if(num.get()==1){
				num.decrementAndGet();
				return (double) Math.round(totalMoney*100)/100;
			}

			/**
			 * 1. 我们需要保证每次尚未抢到的红包的同学数学期望相同 = totalMoney / num（剩余的人数）
			 * 2. 随机数生成服从均匀分布,其生成数据的数学期望=(a+b)/2，a为下界=0，b为上界=maxMoney
			 * 3. 需满足随机数生成的期望==每个能抢到红包的数学期望
			 *    （0+maxMoney)/2= totalMoney / num; 因此 maxMoney=totalMoney / num * 2
			 */
			double maxMoney=totalMoney / num.get() * 2 ;
			Random r=new Random();
			double generateMoney=r.nextDouble()* maxMoney;
			double assignMoney= generateMoney< MIN_MONEY ? MIN_MONEY: Math.floor(generateMoney*100)/100;
			totalMoney-=assignMoney;
			num.decrementAndGet();

			return assignMoney;
		}

	}



}
