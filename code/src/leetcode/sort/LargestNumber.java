package leetcode.sort;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//TODO
public class LargestNumber {

    public static String largestNumber(int[] nums) {

        List<Integer> numList = Arrays.stream(nums)
                .boxed().collect(Collectors.toList());
        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer var1, Integer var2) {

                String s1 = String.valueOf(var1);
                String s2 = String.valueOf(var2);
                BigInteger ss = new BigInteger(s1 + s2);
                BigInteger dd = new BigInteger(s2 + s1);

                return dd.compareTo(ss);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numList) {
            stringBuilder.append(num);
        }

        return stringBuilder.toString().startsWith("0")?"0":stringBuilder.toString();
    }
}
