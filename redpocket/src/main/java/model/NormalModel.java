package model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyibo
 * Date: 2019/10/22
 *
 * 普通红包
 */
public class NormalModel implements PlayModel {

	public static final double MAX_MONEY=200;

	private AtomicInteger num;
	private double money;

	public NormalModel(int n,double money) throws Exception{
		if(n<1){
			throw new Exception("红包个数不能小于1");
		}

		if(money>MAX_MONEY){
			throw new Exception("单个红包不得大于 "+MAX_MONEY);
		}
		this.num=new AtomicInteger(n);
		this.money=money;
	}

	public double generate() throws Exception {
		 if(num.get()>0){
		 	num.decrementAndGet();
		 	return this.money;
		 }else{
		 	throw new Exception("红包已经抢完！");
		 }

	}
}
