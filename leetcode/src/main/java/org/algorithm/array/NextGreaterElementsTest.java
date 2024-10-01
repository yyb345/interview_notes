package org.algorithm.array;

import java.util.Stack;

public class NextGreaterElementsTest {

    // 503. Next Greater Element II
    public static int[] nextGreaterElements(int[] nums) {

        int []result=new int[nums.length];

        Stack<Integer> value=new Stack<>();
        Stack<Integer> index=new Stack<>();

        for(int i=0;i<nums.length;i++){
            result[i]=-1;
            while(value.size()>0){
                int peek = value.peek();
                if(nums[i]>peek){
                    value.pop();
                    result[index.pop()]=nums[i];
                }else{
                    break;
                }
            }
            value.push(nums[i]);
            index.push(i);
        }

        if(value.size()>0){
            for(int j=0;j<nums.length;j++){
                while(value.size()>0){
                    int peek = value.peek();
                    if(nums[j]>peek){
                        value.pop();
                        result[index.pop()]=nums[j];
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }
}
