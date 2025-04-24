package org.algorithm.category.stack;

import java.util.Stack;

/**
 * 71
 * 简化文件路径
 * 解法：采用堆栈，遇到..pop
 */
public class SimplyPath71 {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] pathList = path.split("/");
        for (String word : pathList) {
            if (".".equals(word) || "".equals(word)) {
                continue;
            }
            if ("..".equals(word)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(word);
        }

        // 输出
        if (stack.isEmpty()) {
            return "/";
        } else {
            return "/" + String.join("/", stack);
        }
    }
}
