package org.algorithm.stack;

import java.util.Stack;

/**
 * 232
 * 用堆栈实现队列
 */
public class StackToQueue232 {


    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;
    public StackToQueue232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }
}
