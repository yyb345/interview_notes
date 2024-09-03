package leetcode;

import java.util.ArrayList;
import java.util.List;
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

    List<List<Integer>> ret = new ArrayList<>();
    int N=0;
    int K=0;
    public List<List<Integer>> combine(int n, int k) {
        N=n;
        K=k;
        backTrack(1,new ArrayList<>());
        return ret;
    }

    void backTrack(int i, List<Integer> list){
        if(list.size()==K){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<N;j++){
            list.add(j);
            backTrack(j,list);
            list.add(list.size()-1);
        }
    }
}
