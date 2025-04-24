package org.algorithm.category.stack;

import java.util.Stack;


/**
 * 946
 */
public class IsStackPopOrder {

    public boolean isPopOrder(int [] pushed,int [] popped) {

        Stack<Integer> stack = new Stack<>();
        for(int l=0,h=0;l<pushed.length;l++){

            stack.push(pushed[l]);

            while(h<popped.length && !stack.isEmpty() && popped[h]==stack.peek()){
                stack.pop();
                h++;
            }
        }

        return stack.isEmpty();
    }
}
