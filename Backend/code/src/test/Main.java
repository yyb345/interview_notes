package test;

import java.util.Arrays;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("123");
        stack.push("88");
        String join = String.join("/", stack);
        System.out.println(join);
    }
}
