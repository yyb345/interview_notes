package leetcode;


import leetcode.binarytree.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    Map<Integer,Set<Integer>> preMap = new HashMap<>();
    List<Integer> allData = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites==null || prerequisites.length==0){
            return true;
        }

        // 预处理

        for(int i=0;i<prerequisites.length;i++){
            allData.add(prerequisites[i][0]);
            allData.add(prerequisites[i][1]);
            Set<Integer> preset = preMap.get(prerequisites[i][0]);
            if(preset==null){
                preset = new HashSet();
            }
            preset.add(prerequisites[i][1]);
            preMap.put(prerequisites[i][0],preset);
        }


        boolean[] travel = new boolean[numCourses];
        boolean[] outtravel = new boolean[numCourses];

        // 开始处理
        int sum =0;
        for(int v=0;v<numCourses;v++){
            if(!outtravel[v]){
                if(!canTravel(v,travel,outtravel)){
                    return false;
                }
            }
        }
        return true;
    }


    boolean canTravel(int v,boolean[] travel,boolean[] outtravel){

        if(outtravel[v]){
            return true;
        }
        if(travel[v]){
            return false;
        }

        travel[v]=true;
        outtravel[v]=true;

        Set<Integer> preSet = preMap.get(v);
        if(preSet==null || preSet.isEmpty()){
            travel[v]=false;
            return true;
        }

        for(Integer ss:preSet){
            if(!canTravel(ss,travel,outtravel)){
                return false;
            }
        }

        travel[v]=false;
        return true;
    }

    public String decodeString(String s) {

        if(s==null || s.length()==0 ){
            return null;
        }


        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){

            String ss = s.substring(i,i+1);
            if("[".equals(ss)){
                stack.push("[");
            }else if("]".equals(ss)){
                // process
                String sb = "";
                while(!stack.isEmpty() && !"[".equals(stack.peek())){
                    sb= stack.pop()+sb;
                }

                // 内部
                if(!stack.isEmpty()){
                    stack.pop();
                    String numStr = "";
                    while(!stack.isEmpty()){
                        Pattern pattern = Pattern.compile("[0-9]*");
                        Matcher isNum = pattern.matcher(stack.peek());
                        if (isNum.matches()){
                            numStr = stack.pop()+numStr;
                        }else{
                            break;
                        }
                    }
                    if(!"".equals(numStr)){
                        int num = Integer.parseInt(numStr);
                        stack.push(buildSSS(num,sb));
                    }

                }
            }else {
                stack.push(ss);
            }

        }
        // process result
        String rr = "";
        while(!stack.isEmpty()){
            rr = stack.pop()+rr;
        }

        return rr;
    }

    String buildSSS(int num,String ss){
        String rr = "";
        for(int i=0;i<num;i++){
            rr = rr + ss;
        }
        return rr;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map =new HashMap<>();
        int a =1;
        map.getOrDefault(a,1);
    }

}



