package org.algorithm.twopointer;

/**
 * 125
 * 判断是否为回文串，只判断 字母和数字
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class IsPanlidromic125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;
        String s1 = s.toLowerCase();
        while (l < h) {
            char left = s1.charAt(l);
            if (!isAlpha(left)) {
                l++;
                continue;
            }
            char right = s1.charAt(h);
            if (!isAlpha(right)) {
                h--;
                continue;
            }
            if (left != right) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    boolean isAlpha(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

}
