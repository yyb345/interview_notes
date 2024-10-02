package org.algorithm.stack;

import java.util.Stack;

/**
 * 71
 * 简化文件路径
 */
public class SimplyPath {

    public  String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] pathList = path.split("/");
        for (String word:pathList) {
            wordStack(stack,word);
        }

        // 输出
        if (stack.isEmpty()) {
            return "/";
        } else {
            return  "/"+String.join("/", stack);
        }
    }

    void wordStack(Stack<String> stack, String word){

        if (".".equals(word) || "".equals(word) ){
            return;
        }
        if ("..".equals(word)) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            return;
        }
        stack.push(word);
    }
}
