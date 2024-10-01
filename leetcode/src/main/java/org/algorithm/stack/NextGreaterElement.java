package org.algorithm.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  496
 *  思考 [1,3,4,2]  寻找后边第一个大于其数据-->拓展到其他条件，这个可以用单调栈来解题，那么问题来了，单调栈可以解哪类问题呢？
 *  栈是用来解决不满足xxx条件就add，两个元素进行对比，满足xx条件，就pop，这似乎是一种Pair,就跟磁铁一样。
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int []result=new int[nums1.length];

        Stack<Integer> stack =new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for(int j=0;j<nums1.length;j++){
            result[j]=map.getOrDefault(nums1[j],-1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = new NextGreaterElement().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
        System.out.println();
    }
}
