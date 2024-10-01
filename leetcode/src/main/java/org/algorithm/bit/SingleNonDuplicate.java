package org.algorithm.bit;

//TODO 重新理解一下
public class SingleNonDuplicate {

    // problem 540
    public static int singleNonDuplicate(int[] nums) {
        int uniq = 0;
        for (int num : nums)
            uniq = uniq ^ num;

        return uniq;
    }
}
