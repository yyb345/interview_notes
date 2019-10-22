package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午8:48
 */
public class NormalModelTest {

	private NormalModel  normalModel;
	private int num;
	private double money;

	@Before
	public void init() throws Exception{

		initCase1();
		normalModel=new NormalModel(num,money);
	}

	/**
	 * 正常情况
	 */
	void initCase1(){
		num=10;
		money=4;
	}

	/**
	 * 不满足条件
	 * money大于200
	 */
	void initCase2(){
		num=4;
		money=201;
	}

	/**
	 * 不满足条件
	 * num<1
	 */
	void initCase3(){
		num=0;
		money=201;
	}

	@Test
	public void generateTest(){


		try{
			for(int i=0;i<num;i++){
				double dd = normalModel.generate();
				System.out.println(dd);
			}

		}catch (Exception e){
			e.printStackTrace();
		}


	}

	@Test
	public  void xx(){
		AtomicInteger atomicInteger=new AtomicInteger(10);
		System.out.println(atomicInteger.getAndDecrement());
		System.out.println(atomicInteger.get());
	}

}
