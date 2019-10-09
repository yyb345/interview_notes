package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Created by yangyibo
 * Date: 2019/4/9
 * Time: 下午3:54
 */
public class Stream1 {


	public static void main(String[] args){

		List<String> strings=new ArrayList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");

		OptionalInt max
				= strings.stream()
				//无状态中间操作
				.filter(s -> s.startsWith("A"))
				//无状态中间操作
				.mapToInt(String::length)
				//有状态中间操作
				.sorted()
				//非短路终端操作
				.max();
		System.out.println(max);

	}
}
