package org.algorithm.category.stack;

/**
 * 921
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */
public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int stackSize = 0;
        int right =0;

        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);

            if(cc=='('){
                stackSize++;
            }else if(cc==')'){
                if(stackSize>0){
                    stackSize--;
                }else{
                    right++;
                }
            }
        }

        return stackSize+right;
    }
}
