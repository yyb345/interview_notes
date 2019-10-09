package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by yangyibo
 * Date: 2019/9/18
 * Time: 上午11:18
 */
public class GuavaCacheTest {

	public  static void main(String[] args){


		Cache<Object, Object> cache = CacheBuilder.newBuilder()
				.expireAfterWrite(100, TimeUnit.SECONDS)
				.build();

		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());

	}
}
