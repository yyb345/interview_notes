package org.algorithm.binarytree.judge;

import java.util.Stack;

public class IsValidPreTree {

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] split = preorder.split(",");
        for (int i = 0; i < split.length; i++) {
            String cc = split[i];
            if (cc .equals("#")) {
                if (!stack.isEmpty()) {
                    if (stack.peek() .equals( "#") ){
                        while (!stack.isEmpty() && stack.peek().equals("#")) {
                            stack.pop();
                            stack.pop();
                        }
                    }
                }
                stack.push(cc);
            } else {
                stack.push(cc);
            }
        }
        return stack.size()==1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        new IsValidPreTree().isValidSerialization("1,#,#,#,#");
    }
}
