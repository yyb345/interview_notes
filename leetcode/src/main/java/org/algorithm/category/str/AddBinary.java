package org.algorithm.category.str;

/**
 * 67
 * 两个字符串 二进制加法
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        int bIndex=b.length()-1;
        int aIndex=a.length()-1;
        int preSum = 0;
        StringBuilder sb = new StringBuilder();
        while(aIndex>=0 || bIndex>=0){
            int aa= aIndex>=0 ?a.charAt(aIndex)-'0':0;
            int bb = bIndex>=0 ?b.charAt(bIndex)-'0':0;
            int sum = aa+bb+preSum;

            sb.append(sum%2);
            preSum = sum/2;
            aIndex--;
            bIndex--;
        }

        if(preSum>0){
            sb.append(preSum);
        }

        return sb.reverse().toString();

    }
}
