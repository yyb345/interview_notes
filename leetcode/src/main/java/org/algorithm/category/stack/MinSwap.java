package org.algorithm.category.stack;

import java.util.Stack;

/**
 * 1963
 */
public class MinSwap {

    public int minSwaps(String s) {

        Stack<Character> stack = new Stack<>();

        int count = 0;
        // 1. 将满足的括号消去
        // 2. 消去后，最终成为 ]]]]]]][[[[[ 形式，他需要(count+1)/2 次交换

        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (cc == ']') {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            } else if (cc == '[') {
                stack.push(cc);
            }
        }
        return (count+1)/2;

    }

    public int minSwapsV2(String s) {

        int stackSize=0;

        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (cc == ']') {
                if(stackSize>0){
                    stackSize--;
                }
            } else if (cc == '[') {
                stackSize++;
            }
        }
        return (stackSize+1)/2;

    }
}
