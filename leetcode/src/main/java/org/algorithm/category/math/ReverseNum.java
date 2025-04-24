package org.algorithm.category.math;

/**
 * 7
 */
public class ReverseNum {

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        int newX = 0;
        while (x != 0) {
            int preNewX = newX;
            newX = preNewX * 10 + x % 10;

            // 关键在这，正向和反向计算都是相等的，如果不相等，说明越界了
            if ((newX-(x % 10))/10 !=  preNewX) {
                return 0;
            }

            x = x / 10;
        }

        return newX;

    }
}
