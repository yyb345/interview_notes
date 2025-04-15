package org.algorithm;

import java.util.*;
public class Course {

    Map<Integer,List<Integer>> courseMap  = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {



        // 1. data prepare
        for(int i=0;i<prerequisites.length;i++){
            if(courseMap.get(prerequisites[i][0])==null){
                courseMap.put(prerequisites[i][0],new ArrayList<>(Arrays.asList(prerequisites[i][1])));
            }else{
                List<Integer> list = courseMap.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
                courseMap.put(prerequisites[i][0],list);
            }
        }

        // 2. dfs
        for(Map.Entry<Integer,List<Integer>> entry:courseMap.entrySet()){
            boolean[] visited = new boolean[numCourses];
            visited[entry.getKey()]=true;
            if(!dfs(entry.getValue(),visited)){
                return false;
            }
        }

        return true;
    }

    boolean dfs(List<Integer> nums,boolean[] visited){

        if(nums==null || nums.size()==0){
            return true;
        }

        for(Integer num:nums){
            if(visited[num]){
                return false;
            }
            visited[num]=true;
            dfs(courseMap.get(num),visited);
        }

        return true;
    }


    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int n= x;

        while(n>0){
            stack.push(n%10);
            n = n /10;
        }

        int count = stack.size();
        int sum = 0;
        for(int i=0;i<count;i++){
            sum = sum + (int)Math.pow(10,i)*stack.pop();
        }

        return x==sum;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxVal = 0;
        // 初始化
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 初始化结束
        int startPoint = 0;
        int endPoint = 0;
        dp[0][1] = s.charAt(0)==s.charAt(1);
        maxVal = dp[0][1] ? 1:0;
        endPoint = dp[0][1] ? 1:0;
        for (int i = 1; i < n; i++) {
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[j][i]= (i-j>1) ? dp[j+1][i-1]: true;
                    if(dp[j][i] && i-j>maxVal){
                        maxVal = (i-j);
                        startPoint = j;
                        endPoint = i;
                    }
                }
            }
        }

        return s.substring(startPoint, endPoint + 1);
    }


    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        dfs(matrix,0,0,visited,list,'r');

        return list;
    }

    void dfs(int[][] matrix,int i,int j,boolean[][] visited,
             List<Integer> list,char direction){
        if(visited[i][j]){
            return;
        }
        if(direction=='r'){
            list.add(matrix[i][j]);
            visited[i][j]=true;
            if(j==matrix[0].length-1 || visited[i][j+1]){
                //向⬇️
                dfs(matrix,i+1,j,visited,list,'d');
            }else{
                // 继续👉
                dfs(matrix,i,j+1,visited,list,'r');
            }
        }else if(direction=='d'){
            list.add(matrix[i][j]);
            visited[i][j]=true;
            if(i==matrix.length-1 || visited[i+1][j]){
                //向⬅️
                dfs(matrix,i,j-1,visited,list,'l');
            }else{
                //继续向⬇️
                dfs(matrix,i+1,j,visited,list,'d');
            }
        }else if(direction=='l'){
            list.add(matrix[i][j]);
            visited[i][j]=true;
            if(j==0 || visited[i][j-1]){
                // 向上
                dfs(matrix,i-1,j,visited,list,'u');
            }else{
                // 向⬅️
                dfs(matrix,i,j-1,visited,list,'l');
            }
        }else if(direction=='u'){
            list.add(matrix[i][j]);
            visited[i][j]=true;
            if(i==0 || visited[i-1][j]){
                // 向👉
                dfs(matrix,i,j+1,visited,list,'r');
            }else {
                // 继续向⬆️
                dfs(matrix,i-1,j,visited,list,'u');
            }
        }
    }




    public static void rotate(int[] nums, int k) {

        rotateWithIndex(nums,0,nums.length-1,k);
    }

   static void rotateWithIndex(int[] nums, int start, int end, int k) {

        if(start>=end){
            return;
        }
        if (k == 0) {
            return;
        }

        int length = end - start + 1;

        k = k % length;

        int ll = start;

        int hh = end - k + 1;

        for (int j = 0; j < k; j++) {
            int left = nums[ll + j];
            int right = nums[hh + j];
            nums[ll + j] = right;
            nums[hh + j] = left;
        }

        rotateWithIndex(nums,ll+k,end,k);
    }

    int ret = 0;
    public int findTargetSumWays(int[] nums, int target) {

        boolean[] visited = new boolean[nums.length];
        backTrack(nums,visited,target,0);

        return ret;

    }

    void backTrack(int[] nums,boolean[] visited,int target,int len){

        if(target==0 && len==nums.length){
            ret++;
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            backTrack(nums,visited,target+nums[i],len++);
            backTrack(nums,visited,target-nums[i],len++);
            visited[i]=false;
        }
    }

    public int maximumLength(int[] nums) {
        int m = nums.length;
        int[] dp0 = new int[m];
        int[] dp1 = new int[m];
        int maxLength =2 ;
        dp0[0]=1;
        dp1[0]=1;

        for(int i=1;i<m;i++){
            for(int j=0;j<i;j++){
                if((nums[i]+nums[j])%2==0){
                    dp0[i]=Math.max(dp0[j]+1,dp0[i]);
                }else {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
            maxLength = Math.max(maxLength,Math.max(dp0[i],dp1[i]));
        }

        return maxLength;
    }

    public String convert(String s, int numRows) {

        if(numRows==1) return s;
        if(s.length()<numRows) return s;
        //
        StringBuffer[] levelString = new StringBuffer[numRows];
        for(int i=0;i<numRows;i++){
            levelString[i]= new StringBuffer();
        }

        boolean goingdown = true;
        int index = 0;
        for(char c:s.toCharArray()){
            levelString[index].append(c);
            if(goingdown){
                if(index>=numRows-1){
                    goingdown=false;
                    index--;
                }else{
                    index++;
                }
            }else{
                if(index<=0){
                    goingdown=true;
                    index++;
                }else {
                    index--;
                }
            }
        }

        StringBuffer ss = new StringBuffer();
        for(StringBuffer sb:levelString){
            ss.append(sb.toString());
        }

        return ss.toString();
    }


    public static void main(String[] args){
        Integer[] nums = {1, 2, 3};
        Arrays.sort(nums,(a,b)->b.compareTo(a));
       System.out.println(Arrays.asList(nums));

    }
}
