package leetcode.stack;

import java.util.Stack;

/**
 * 最小栈 小红书二面
 */
public class MinStack  {


    Stack<Integer> dataStack;

    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else {
            Integer peek = minStack.peek();
            minStack.push(Math.min(peek,x));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        if(dataStack.isEmpty()){
            return -1;
        }
        return dataStack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }
}
