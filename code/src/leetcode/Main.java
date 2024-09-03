package leetcode;


import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {



      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] travel = new boolean[m][n];
                if(dfs(board,i,j,m,n,travel,word.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }

   static boolean  dfs(char[][] board,int i,int j,int m,int n,boolean[][] travel,String word){
        if(i<0 || j<0 || i>=m || j>=n || travel[i][j]){
            return false;
        }
        if(!word.startsWith(String.valueOf(board[i][j]))){
            return false;
        }
        travel[i][j]= true;
        if(word.length()==1){
            return true;
        }
        String newWord = word.substring(1);
        if(dfs(board,i+1,j,m,n,travel,newWord)){
            return true;
        }
        if(dfs(board,i-1,j,m,n,travel,newWord)){
            return true;
        }
        if(dfs(board,i,j+1,m,n,travel,newWord)){
            return true;
        }

        if(dfs(board,i,j-1,m,n,travel,newWord)){
            return true;
        }
        return false;
    }


//    public static int maxProduct(int[] nums) {
//
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//        int m = nums.length;
//        int[] F = new int[m];
//        F[0]=nums[0];
//        for(int i=1;i<m;i++){
//            int product = nums[i];
//            F[i]=Math.max(F[i],nums[i]);
//            for(int j=i-1;j>=0;j--){
//                F[i] = Math.max(F[i],productnums[j]);
//                product= productnums[j];
//            }
//
//            F[i]=Math.max(F[i-1],F[i]);
//        }
//
//        return F[m-1];
//    }


    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] travel = new boolean[m][n];
        List<Integer> list = new ArrayList<>();
        dfs(0, 0, m, n, matrix, travel, 'R', list);
        return list;
    }

    boolean dfs(int i, int j, int m, int n, int[][] matrix, boolean[][] travel, char direction, List<Integer> list) {
        if (i < 0 || j < 0 || i >= m || j >= n || travel[i][j]) {
            return false;
        }

        list.add(matrix[i][j]);
        travel[i][j] = true;
        if (direction == 'R') {
            // R
            if (!dfs(i, j + 1, m, n, matrix, travel, 'R', list)) {
                // D
                dfs(i + 1, j, m, n, matrix, travel, 'D', list);
            }
        } else if (direction == 'L') {
            // L
            if (!dfs(i, j - 1, m, n, matrix, travel, 'R', list)) {
                // U
                dfs(i - 1, j, m, n, matrix, travel, 'U', list);
            }


        } else if (direction == 'D') {
            // D
            if (!dfs(i + 1, j, m, n, matrix, travel, 'D', list)) {
                // L
                dfs(i, j - 1, m, n, matrix, travel, 'R', list);
            }


        } else if (direction == 'U') {

            // U
            if (!dfs(i - 1, j, m, n, matrix, travel, 'U', list)) {
                // R
                dfs(i, j + 1, m, n, matrix, travel, 'R', list);
            }

        }

        return true;
    }

    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int m = nums.length;
        int[] F = new int[m];
        F[0]=1;
        for (int num : nums) {
            set.add(num);
        }

        for(int i=1;i<m && !set.isEmpty();i++){
            int num=1;
            int current= nums[i];
            while(set.contains(--current)){
                num++;
                set.remove(current);
            }
            current= nums[i];
            while(set.contains(++current)){
                num++;
                set.remove(current);
            }

            F[i]=Math.max(num,F[i-1]);

        }

        return F[m-1];
    }


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

    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }


        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]>target){
                h = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]==target){
                // find end
                int end=mid;
                while(end<nums.length && nums[end]==target ){
                    end++;
                }

                int[] F = new int[2];
                F[1]=Math.max(end-1,0);
                // find start
                int start = mid;
                while(start>0 && nums[start]==target){
                    start--;
                }
                F[0]=start+1;
                return F;
            }
        }

        return new int[]{-1,-1};
    }


    public static boolean wordBreak(String s, List<String> wordDict) {

        // 预处理


        return dfs(s,0,s.length(),wordDict,new HashSet<>());
    }


    static boolean dfs(String s,int start,int m,List<String> wordDict,Set<String> travled){
        if(start>=m){
            return true;
        }
        String remainStr = s.substring(start);



        for(String ww:wordDict) {
            if (start > 0 && s.substring(0, start).equals(ww)) {
                travled.add(ww);
            }
        }

        for(String ww:wordDict){
            if(travled.contains(ww)){
                continue;
            }
            if(remainStr.startsWith(ww)){
                if(dfs(s,start+ww.length(),m,wordDict,travled)){
                    return true;
                }
            }
        }

        return false;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int result = 1;
        int start = 0;

        Map<String,Integer> map = new HashMap<>();
        map.put(s.substring(0,1),0);
        for(int i=1;i<s.length();i++){
            String currentStr = s.substring(i, i + 1);
            Integer preIndex = map.get(currentStr);
            if(preIndex!=null && preIndex>=start){
                start = preIndex+1;
            }else{
                result = Math.max(result,i-start+1);
            }
            map.put(currentStr,i);
        }
        return result;

    }


    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0){
            return new ArrayList<>();
        }

        int m = candidates.length;
        for(int i=0;i<m;i++){
            dfs(i,m,candidates,target,new ArrayList<>());
        }
        return ret;
    }

    void dfs(int i,int m,int[] nums,int target,List<Integer> list) {

        if (i >= m || target < 0) {
            return ;
        }
        if (nums[i] == target) {
            list.add(nums[i]);
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            list.remove(list.size()-1);

            for (List<Integer> successList : ret) {
                if(listCompare(successList,arrayList)){
                    return;
                }
            }
            ret.add(arrayList);
            return ;
        }

        list.add(nums[i]);
        for (int k = 0; k < m; k++) {
            dfs(k, m, nums, target - nums[i], list);
        }
        list.remove(list.size()-1);
    }


    boolean listCompare(List<Integer> list1,List<Integer> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        Map<Integer,Integer> list1Count = new HashMap<>();
        for (Integer num : list1) {
            if(list1Count.get(num)!=null){
                list1Count.put(num,list1Count.get(num)+1);
            }else {
                list1Count.put(num,1);
            }
        }

        Map<Integer,Integer> list2Count = new HashMap<>();
        for (Integer num : list2) {
            if(list2Count.get(num)!=null){
                list2Count.put(num,list2Count.get(num)+1);
            }else {
                list2Count.put(num,1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : list2Count.entrySet()) {
            if(list1Count.get(entry.getKey())==null || !list1Count.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }


    public int jump(int[] nums) {


        int m = nums.length;
        int[] F = new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if((nums[j]+j)>=i){
                    if(F[i]==0){
                        F[i]=F[j]+1;
                    }else {
                        F[i]=Math.min(F[j]+1,F[i]);
                    }
                }
            }
        }

        return F[m-1];
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


    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] F = new int[m][n];

        int max = 0;
        F[0][0] = text1.charAt(0)==text2.charAt(0) ? 1:0;
        for(int i=1;i<m;i++){
            F[i][0]= Math.max(F[i-1][0],text1.charAt(i)==text2.charAt(0) ? 1:0);
            max = Math.max(F[i][0],max);
        }

        for(int j=1;j<n;j++){
            F[0][j]= Math.max(F[0][j-1],text1.charAt(0)==text2.charAt(j) ? 1:0);
            max = Math.max(F[0][j],max);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    F[i][j] = F[i-1][j-1]+1;
                }else{
                    F[i][j] = Math.max(F[i][j-1],F[i-1][j]);

                }
                max = Math.max(F[i][j],max);
            }
        }

        return max;

    }


    Map<Integer,Set<Integer>> preMap = new HashMap<>();
    List<Integer> cicleList = new ArrayList<>();
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

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;
        int[] F = new int[n];

        for(int i=0;i<n;i++){
            F[i]=1;
        }

        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    F[i]= Math.max(F[j]+1,F[i]);
                    max = Math.max(max,F[i]);
                }
            }


        }

        return max;
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

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] travel = new boolean[m][n];
        int[][] pathSum = new int[m][n];
        return dfs(grid,pathSum,travel,m,n,0,0,0);
    }

    int dfs(int[][] grid,int[][] pathSum,boolean[][] travel,int m,int n,int i,int j,int sum){
        if(i<0 || j<0 || i>=m || j>=n ){
            return 0;
        }

        if(travel[i][j]){
            return pathSum[i][j];
        }

        if(i==m-1 && j==n-1){
            return grid[i][j];
        }

        int vv = grid[i][j];
        int down = dfs(grid,pathSum,travel,m,n,i+1,j,sum);
        int right = dfs(grid,pathSum,travel,m,n,i,j+1,sum);
        if(down>0 && right>0){
            vv += Math.min(down,right);
        }else if(down==0 && right>0){
            vv += right;
        }else if(down>0 && right==0){
            vv += down;
        }
        pathSum[i][j]=vv;
        travel[i][j]=true;
        return vv;
    }


    public static int  lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        // start  end
        // 如何更新这个窗口
        //
        int startIndex = 0;
        int endIndex = 0;
        int max = 1;
        Map<Character,Integer> map = new HashMap<>();

        //
        for(int i=0;i<s.length();i++){
            endIndex = i;
            char endChar =  s.charAt(i);
            if(map.get(endChar)!=null){
                //  包含
                startIndex = Math.max(startIndex,map.get(endChar)+1);
                //
            }
            map.put(endChar,i);

            max = Math.max(max,endIndex-startIndex+1);

        }

        return max;
    }

    public static int maxProduct(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];
        dp[0][0]=nums[0];
        int maxVal=dp[0][0];

        for(int i=1;i<nums.length;i++){
            maxVal = Math.max(maxVal,nums[i]);
            for(int j=0;j<i;j++){
                dp[j][i]=dp[j][i-1]*nums[i];
                maxVal = Math.max(maxVal,dp[j][i]);
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {

//        char[][] boards = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//
//        System.out.println(exist(boards,"ABCCED"));

//         int[][] nums = new int[][]{{9,9,0,8,9,0,5,7,2,2,7,0,8,0,2,4,8},{4,4,2,7,6,0,9,7,3,2,5,4,6,5,4,8,7},{4,9,7,0,7,9,2,4,0,2,4,4,6,2,8,0,7},{7,7,9,6,6,4,8,4,8,7,9,4,7,6,9,6,5},{1,3,7,5,7,9,7,3,3,3,8,3,6,5,0,3,6},{7,1,0,7,5,0,6,6,5,3,2,6,0,0,9,5,7},{6,5,6,3,8,1,8,6,4,4,3,4,9,9,3,3,1},{1,0,2,9,7,9,3,1,7,5,1,8,2,8,4,7,6},{9,6,7,7,4,1,4,0,6,5,1,9,0,3,2,1,7},{2,0,8,7,1,7,4,3,5,6,1,9,4,0,0,2,7},{9,8,1,3,8,7,1,2,8,3,7,3,4,6,7,6,6},{4,8,3,8,1,0,4,4,1,0,4,1,4,4,0,3,5},{6,3,4,7,5,4,2,2,7,9,8,4,5,6,0,3,9},{0,4,9,7,1,0,7,7,3,2,1,4,7,6,0,0,0}};

         //
//        int[][] nums = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};

//        int[][] nums = new int[][]{{1,0},{2,0},{2,1},{3,1},{3,2},{4,2},{4,3},{5,3},{5,4},{6,4},{6,5},{7,5},{7,6},{8,6},{8,7},{9,7},{9,8},{10,8},{10,9},{11,9},{11,10},{12,10},{12,11},{13,11},{13,12},{14,12},{14,13},{15,13},{15,14},{16,14},{16,15},{17,15},{17,16},{18,16},{18,17},{19,17},{19,18},{20,18},{20,19},{21,19},{21,20},{22,20},{22,21},{23,21},{23,22},{24,22},{24,23},{25,23},{25,24},{26,24},{26,25},{27,25},{27,26},{28,26},{28,27},{29,27},{29,28},{30,28},{30,29},{31,29},{31,30},{32,30},{32,31},{33,31},{33,32},{34,32},{34,33},{35,33},{35,34},{36,34},{36,35},{37,35},{37,36},{38,36},{38,37},{39,37},{39,38},{40,38},{40,39},{41,39},{41,40},{42,40},{42,41},{43,41},{43,42},{44,42},{44,43},{45,43},{45,44},{46,44},{46,45},{47,45},{47,46},{48,46},{48,47},{49,47},{49,48},{50,48},{50,49},{51,49},{51,50},{52,50},{52,51},{53,51},{53,52},{54,52},{54,53},{55,53},{55,54},{56,54},{56,55},{57,55},{57,56},{58,56},{58,57},{59,57},{59,58},{60,58},{60,59},{61,59},{61,60},{62,60},{62,61},{63,61},{63,62},{64,62},{64,63},{65,63},{65,64},{66,64},{66,65},{67,65},{67,66},{68,66},{68,67},{69,67},{69,68},{70,68},{70,69},{71,69},{71,70},{72,70},{72,71},{73,71},{73,72},{74,72},{74,73},{75,73},{75,74},{76,74},{76,75},{77,75},{77,76},{78,76},{78,77},{79,77},{79,78},{80,78},{80,79},{81,79},{81,80},{82,80},{82,81},{83,81},{83,82},{84,82},{84,83},{85,83},{85,84},{86,84},{86,85},{87,85},{87,86},{88,86},{88,87},{89,87},{89,88},{90,88},{90,89},{91,89},{91,90},{92,90},{92,91},{93,91},{93,92},{94,92},{94,93},{95,93},{95,94},{96,94},{96,95},{97,95},{97,96},{98,96},{98,97},{99,97}};



//       System.out.println(new Main().minPathSum(nums));

//       PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2, (o1, o2) -> o2.compareTo(o1));
//       priorityQueue.add(2);
//       priorityQueue.add(1);
//
//       System.out.println(priorityQueue.peek());
//       int[] F = new int[4];
//       String xx = "12345";
//       System.out.println(F.length);
//       System.out.println(xx.length());
//       String[] pp = new String[]{"1","2"};

        maxProduct(new int[]{2,-5,-2,-4,3});
    }

}



