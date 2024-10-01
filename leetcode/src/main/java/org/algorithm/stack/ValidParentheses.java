package org.algorithm.stack;

import java.util.Stack;

//TODO
public class ValidParentheses {

    public boolean isValidParentheses(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.size()>0 && (c=='}' || c==')' || c==']')){
                if((c=='}' && stack.peek()=='{') || (c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='[')){
                    stack.pop();
                    continue;
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
