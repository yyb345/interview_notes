package org.algorithm.category.dfs;

import java.util.*;

public class DifferentWayParenteness {



    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {

        return dfs(expression,0,expression.length()-1);
    }


    List<Integer> dfs(String expression,int start,int end){
        if(start<0 || end>=expression.length()){
            return new ArrayList<>();
        }

        String subExpression = expression.substring(start, end + 1);
        if (!subExpression.contains("*") && !subExpression.contains("+") && !subExpression.contains("-")) {
            return Arrays.asList(Integer.parseInt(subExpression));
        }

        if(map.containsKey(subExpression)){
            return map.get(subExpression);
        }

        List<Integer> ret = new ArrayList<>();
        for(int i=start;i<=end;i++){
            char c = expression.charAt(i);
            if(c=='*' || c=='-' || c=='+'){
                List<Integer> leftList = dfs(expression, start, i-1 );
                List<Integer> rightList = dfs(expression, i+1, end);

                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                         if(c=='*' ){
                             ret.add(left*right);
                         }else if (c=='+'){
                             ret.add(left+right);
                         }else if(c=='-'){
                             ret.add(left-right);
                         }
                    }
                }
            }
        }


        map.put(subExpression,ret);
        return  ret;

    }

    public static void main(String[] args) {

        List<Integer> list1 = new DifferentWayParenteness().diffWaysToCompute("2*3-4*5");
        System.out.println(list1);
    }

}
