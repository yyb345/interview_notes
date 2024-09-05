package leetcode.stack;

import java.util.Stack;

//TODO

/**
 * 946
 */
public class IsStackPopOrder {

    public boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int index=0,i=0;
        while(index<popA.length){
            if(i<pushA.length)
                stack.push(pushA[i++]);

            if(stack.peek()!=popA[index]){
                if(i==pushA.length){
                    return false;
                }
            } else{
                while(!stack.isEmpty() && stack.peek()==popA[index]){
                    index++;
                    stack.pop();
                }
            }
        }

        return true;

    }
}
