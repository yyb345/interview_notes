package problems;

import java.util.Stack;

public class ProblemTest {

    public boolean isValid(String s) {

        Stack<String> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.substring(i,i+1));
        }

        stacksubsub(stack);

        return stack.isEmpty();
    }

    void stacksubsub(Stack<String> stack){
        if(stack.isEmpty()){
            return;
        }
        if("{".equals(stack.peek()) || "[".equals(stack.peek())){
            return;
        }else if("}".equals(stack.peek())){
            stack.pop();
            if("{".equals(stack.peek())){
                stack.pop();
                stacksubsub(stack);
            }else{
                stack.push("}");
            }
        }else if("]".equals(stack.peek())){
            stack.pop();
            if("[".equals(stack.peek())){
                stack.pop();
                stacksubsub(stack);
            }else{
                stack.push("]");
            }
        }
    }
}
