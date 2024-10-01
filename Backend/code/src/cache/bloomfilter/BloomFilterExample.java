package cache.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class BloomFilterExample {

    public static void main(String[] args) {
        int expectedInsertions = 1000;
        double falsePositiveRate = 0.00;

        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), expectedInsertions, falsePositiveRate);

        // 添加 appkey
        String appKey1 = "abcdef";
        String appKey2 = "123456";
        bloomFilter.put(appKey1);
        bloomFilter.put(appKey2);

        // 判断 appkey 是否存在
        String testAppKey1 = "abcdef";
        String testAppKey2 = "xyz";
        System.out.println("AppKey 'abcdef' may exist: " + bloomFilter.mightContain(testAppKey1));
        System.out.println("AppKey 'xyz' may exist: " + bloomFilter.mightContain(testAppKey2));
    }
}
