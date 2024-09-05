package leetcode;


import leetcode.binarytree.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static String largestNumber(int[] nums) {

        List<Integer> numList = Arrays.stream(nums)
                .boxed().collect(Collectors.toList());
        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer var1, Integer var2) {

                String s1 = String.valueOf(var1);
                String s2 = String.valueOf(var2);
                BigInteger ss = new BigInteger(s1 + s2);
                BigInteger dd = new BigInteger(s2 + s1);

                return dd.compareTo(ss);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numList) {
            stringBuilder.append(num);
        }

        return stringBuilder.toString().startsWith("0")?"0":stringBuilder.toString();
    }



    TreeNode preNode = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode ll = root.left;
        TreeNode rr = root.right;

        if(preNode == null){
            preNode = root;
        }else{
            preNode.right = root;
            preNode = root;
        }
        dfs(ll);
        dfs(rr);
    }


    Queue<Node> nodeQueue = new LinkedList<>();
    int rr = -1;


    class Node {
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

        boolean[][] travel = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    nodeQueue.add(new Node(i,j));
                    travel[i][j] = true;
                }else if(grid[i][j]==0){
                    travel[i][j] = true;
                }
            }
        }

        bfs(grid,travel,m,n);
        // 判断，如果还存在1，则返回-1

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!travel[i][j]){
                    return -1;
                }
            }
        }

        return rr;
    }


    void bfs(int[][] grid,boolean[][] travel,int m,int n){
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for(int k=0;k<size;k++){
                Node node =  nodeQueue.poll();
                int i=node.x;
                int j = node.y;
                travelNode(i+1,j,grid,travel,m,n);
                travelNode(i-1,j,grid,travel,m,n);
                travelNode(i,j+1,grid,travel,m,n);
                travelNode(i,j-1,grid,travel,m,n);
            }
            rr++;
        }
    }

    void travelNode(int i,int j,int[][] grid,boolean[][] travel,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n  || travel[i][j]){
            return;
        }

        nodeQueue.add(new Node(i,j));
        travel[i][j] = true;
    }





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


    }

}



