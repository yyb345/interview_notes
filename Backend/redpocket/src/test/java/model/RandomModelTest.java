package model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;


/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午8:28
 */
public class RandomModelTest {


	private RandomModel randomModel;
	private int num;
	private double money;

	@Before
	public void init() throws Exception {
		initCase1();
		//initCase2();
		//initCase3();
		randomModel=new RandomModel(num,money);

	}

	/**
	 * 正常条件
	 */
	void initCase1(){
		num=10;
		money=4;
	}

	/**
	 * 不满足条件
	 * 每个人分到不足0.01
	 */
	void initCase2(){
		num=4;
		money=0.02;
	}

	/**
	 * 不满足条件
	 * num=0
	 */
	void initCase3(){
		num=0;
		money=0.02;
	}


	/**
	 * 函数功能测试
	 * @throws Exception
	 */
	@Test
	public void generateTest() throws Exception{

		double sum=0;
		for(int i=0;i<num;i++){
			double d = randomModel.generate();
			sum=add(sum,d);
			System.out.println(d);
		}

		assertTrue(sum==money);

	}




	//数值精准计算
	public static double add(double m1, double m2) {
		BigDecimal p1 = new BigDecimal(Double.toString(m1));
		BigDecimal p2 = new BigDecimal(Double.toString(m2));
		return p1.add(p2).doubleValue();

	}

}
