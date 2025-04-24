package org.algorithm.category.stack;

import java.util.Stack;

/**
 * 20
 * 解法：采用堆栈
 */
public class ValidParentheses20 {

    public boolean isValidParentheses(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.size()>0 && (c=='}' || c==')' || c==']')){
                if((c=='}' && stack.peek()=='{') || (c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='[')){
                    stack.pop();
                }else {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        if(stack.size()>0)
            return false;
        else
            return true;

    }
}
