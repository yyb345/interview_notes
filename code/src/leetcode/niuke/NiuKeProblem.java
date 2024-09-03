package leetcode.niuke;

import leetcode.ListNode;
import leetcode.binarytree.TreeNode;

import java.util.Stack;
import java.util.*;

public class NiuKeProblem {


   // [6,8,10,0,2,4]

     int  F(int[] nums,int target){
        return this.F1(nums,0,nums.length-1,target);
    }

     int F1(int[] nums,int l,int r,int target){

        if(l>r){
            return -1;
        }

        int mid = l +(r-l)/2;

        if(nums[mid]>nums[r]){
            if(target>nums[mid]){
                return F1(nums,mid+1,r,target);
            }else if(target<nums[mid]) {
                int left = F1(nums,l,mid-1,target);
                int right = F1(nums,mid+1,r,target);

                if(left!=-1){
                    return  left;
                }
                if(right!=-1){
                    return right;
                }
                return -1;
            }else {
                return mid;
            }
        }else if(nums[mid]<nums[r]){
            //二分法寻找target

            if(target<nums[mid]){
                return F1(nums,l,mid-1,target);
            }else if(target>nums[mid]){

                if(target<=nums[r]){
                    int ret = binarySearch(nums, mid, r, target);
                    return ret;
                }else {
                    return F1(nums,l,mid-1,target);
                }
            }else {
                return  mid;
            }
        }else {
            if(target==nums[mid]){
                return  mid;
            }
        }
        return  -1;
    }

    int binarySearch(int[] nums,int l,int h,int target){

        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                h = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }



    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[] f= new int[V+1];
        for(int i=0;i<=V;i++){
            f[i]=0;
        }
        int max = 0;

        for(int j=0;j<n;j++) {
            for (int i = 0; i <= V; i++) {
                if (i >= vw[j][0]) {
                    f[i] = Math.max(f[i], f[i - vw[j][0]] + vw[j][1]);
                }
            }
        }

        return f[V];
    }




    // leetcode 230
    public static int kthSmallest(TreeNode root, int k) {

         if(root==null || k==0){
             return -1;
         }
        int leftNum = nodeNum(root.left);

        if(leftNum+1==k){
            return root.val;
        }else if(k>(leftNum+1)){
            return kthSmallest(root.right,k-leftNum-1);
        }else {
            return kthSmallest(root.left,k);
        }

    }

    public  static  int nodeNum(TreeNode root){
         if(root==null){
             return 0;
         }
         return nodeNum(root.left)+nodeNum(root.right)+1;
    }


    // leecode 94
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ret = new ArrayList<>();
         inorderAdd(root,ret);
         return ret;
    }


    public void inorderAdd(TreeNode root,List<Integer> list) {

         if(root==null){
             return;
         }
         inorderAdd(root.left,list);
         list.add(root.val);
         inorderAdd(root.right,list);
    }


    public boolean isValidBST(TreeNode root) {
         if(root==null){
             return false;
         }

         if(root.left!=null){
             if(root.left.val>=root.val) return false;
             if(!isValidBST(root.left)) return false;
             if(maxNode(root.left)>=root.val) return false;
         }

         if(root.right!=null){
             if(root.right.val<=root.val) return false;
             if(!isValidBST(root.right)) return false;
             if(minNode(root.right)<=root.val) return false;
         }

         return true;
    }

    public int minNode(TreeNode root){
         if(root==null){
             return -1;
         }
         if(root.left==null){
             return root.val;
         }else {
             return minNode(root.left);
         }
    }

    public int maxNode(TreeNode root){
        if(root==null){
            return -1;
        }
        if(root.right==null){
            return root.val;
        }else {
            return maxNode(root.right);
        }
    }



    TreeNode leftEndNode =null;
    public void flatten(TreeNode root) {

         if (root==null){
             return;
         }

         if(root.right!=null){
             flatten(root.right);
         }

        if(root.left!=null){
            flatten(root.left);
        }


        if(root.left!=null && root.right!=null){
            findLeftNode(root.left);
            leftEndNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }else if(root.left!=null && root.right==null){
            root.right = root.left;
            root.left = null;
        }

    }


    void findLeftNode(TreeNode root){

        leftEndNode = root;
         if(root.left!=null){
             findLeftNode(root.left);
         }
         if(root.right!=null){
             findLeftNode(root.right);
         }
    }


    // 113
   List<List<Integer>> finalRsult = new ArrayList<>();

    public void dfsPath(TreeNode root,int sum,List<Integer> ret){
        if(root==null){
            return;
        }

        ret.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==root.val){
                List<Integer> addList = new ArrayList<>(ret);
                finalRsult.add(addList);
            }
        }

        if(root.left!=null){
            dfsPath(root.left,sum-root.val,ret);
        }

        if(root.right!=null){
            dfsPath(root.right,sum-root.val,ret);
        }

        ret.remove(ret.size()-1);
    }

    // let 112


    public boolean hasDFS(TreeNode root,int sum){

        if(root==null){
            return false;
        }

        if(root.left==null && root.right==null){
            if(root.val==sum){
                return true;
            }
        }

        if(root.left!=null){
            if(hasDFS(root.left,sum-root.val)){
                return true;
            }
        }

        if(root.right!=null){
            if(hasDFS(root.right,sum-root.val)){
                return true;
            }
        }

        return false;
    }



    // leetcode 236

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p==null || q==null ){
            return null;
        }


         TreeNode ret = null;



        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findNodePath(root, p.val,new ArrayList<>(),pPath);
        findNodePath(root, q.val,new ArrayList<>(),qPath);

        int index =0 ;
        while(index<Math.min(pPath.size(),qPath.size())){
            TreeNode pNode = pPath.get(index);
            TreeNode qNode = qPath.get(index);
            if(pNode.val ==qNode.val){
                ret = pNode;
            }else {
                break;
            }
            index++;
        }

        return ret;
    }



    public boolean findNodePath(TreeNode root,int target,List<TreeNode> list,List<TreeNode> ret){

        if(root==null){
            return false;
        }

        list.add(root);
        if(root.val==target){
            ret.addAll(new ArrayList<>(list));
            return true;
        }
        if(root.left!=null){
            if(findNodePath(root.left,target,list,ret)){
                return true;
            }
        }

        if(root.right!=null){
            if(findNodePath(root.right,target,list,ret)){
                return true;
            }
        }
        list.remove(root);

        return false;
    }





    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p==null || q==null){
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val,q.val);
        if(root.val < min){
            return lowestCommonAncestor3(root.right,p,q);
        }else if(root.val> max){
            return lowestCommonAncestor3(root.left,p,q);
        }else if(root.val== p.val){
            return p;
        }else if(root.val==q.val){
            return q;
        }else if(root.val>min && root.val<max){
            return root;
        }

        return null;
    }


    int minSum = Integer.MAX_VALUE;
    // 64
    public int minPathSum(int[][] grid) {

        if(grid==null || grid.length==0){
            return -1;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        dp[0][0]=grid[0][0];
        for(int j=1;j<n;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }

        for(int i=1;i<m;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }


    //leetcode 19
    public void dfsMinPath(int[][] grid,int i,int j,int sum){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ){
            return;
        }
        sum += grid[i][j];
        if(i==grid.length-1 && j==grid[0].length-1){
            minSum = Math.min(sum,minSum);
            return;
        }
        dfsMinPath(grid,i+1,j,sum);
        dfsMinPath(grid,i,j+1,sum);

    }



    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode currentNode = findNNode(head, n );
        ListNode preNode = findNNode(head, n + 1);

        if(preNode!=null && currentNode!=null){
            preNode.next = currentNode.next;
        }else if(preNode==null && currentNode!=null){
            return currentNode.next;
        }else if(preNode==null && currentNode==null){
            return head;
        }else if(preNode!=null && currentNode==null){
            return preNode;
        }

        return head;
    }


    public ListNode findNNode(ListNode head,int n){
        if(head==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        int N = n;
        while(N>0){
            if(fast==null ){
                return null;
            }
            fast = fast.next;
            N--;
        }


        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }





    public int[] reversePrint(ListNode head) {

        if(head==null){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();

        ListNode currentNode = head;
        while(currentNode!=null){
            stack.push(currentNode.val);
            currentNode = currentNode.next;
        }

        int[] ret = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ret[i++]=stack.pop();
        }
        return  ret;

    }


    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0){
            return true;
        }
        return verifyPostorder(postorder,0,postorder.length-1);
    }

    public boolean verifyPostorder(int[] postorder,int start,int end) {

        if(start<0){
            return true;
        }
        if(end<=0){
            return true;
        }
        if(start>=end){
            return true;
        }
        int rootVal = postorder[end];

        // check right valid
        int index=end-1;
        int shfit = 0;
        // find right child
        while(index>=start){
            if(postorder[index]>rootVal){
                index--;
                shfit++;
            }else{
                break;
            }
        }

        boolean right = verifyPostorder(postorder,end-shfit,end-1);

        if(!right){
            return false;
        }

        // check left valid
        boolean leftValid = true;
        for(int i=start;i<(end-shfit);i++){
            if(postorder[i]>rootVal){
                return false;
            }
        }

        boolean left = verifyPostorder(postorder,start,end-shfit-1);

        if(!left){
            return false;
        }

        return true;

    }


    public String replaceSpace(String s) {
        if(s==null){
            return null;
        }
        if(s.length()==0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(" ".equals(s.substring(i,i+1))){
                sb.append("%20");
            }else {
                sb.append(s.substring(i,i+1));
            }
        }

        return sb.toString();
    }


    public String reverseLeftWords(String s, int n) {
        if(s==null){
            return null;
        }
        if(s.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n,s.length())).append(s.substring(0, n));
        return sb.toString();
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        if(nums==null){
            return 0;
        }

        int l = 0;
        int h = nums.length-1;
        int mid = l+(h-l)/2;
        boolean find = false;
        int index = 0;
        while(l<=h){
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                h = mid-1;
            }else if(nums[mid]==target){
                find = true;
                index = mid;
                break;
            }
        }

        if(find){
            int left = index;
            int right = index;
            while(left>=0 && nums[left]==target){
                left--;
            }

            while(right<=nums.length-1 && nums[left]==target){
                right++;
            }
            return right-left+1;
        }else {
            return 0;
        }

    }


    public int[] levelOrder(TreeNode root) {

        if(root==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            list.addAll(levelList);
        }

        return  list.stream().mapToInt(i->i).toArray();
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {


        if(root==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> list = new ArrayList<>();
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }

            if(!reverse){
                list.add(levelList);
            }else {
                List<Integer> reverseList = new ArrayList<>();
                for(int i=levelList.size()-1;i>=0;i--){
                    reverseList.add(levelList.get(i));
                }
                list.add(reverseList);
            }

            reverse = !reverse;
        }

        return list;
    }


    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && j>0){
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }else if(i==0 && j>0){
                    dp[i][j]= dp[i][j-1]+grid[i][j];
                }else if(i>0 && j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }else if(i==0 && j==0){
                    dp[i][j] =grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }


    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];

        int min=prices[0];
        int max = 0;

        for(int i=1;i<n;i++){
            dp[i]= Math.max(prices[i]-min,0);
            min = Math.min(min,dp[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }



    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(A==null && B!=null){
            return false;
        }else if(A==null && B==null){
            return true;
        }else if(A!=null && B==null){
            return true;
        }

        if(A.val==B.val){
            return (isSameStructure(A.left,B.left) && isSameStructure(A.right,B.right)) || (isSubStructure(A.left,B) || isSubStructure(A.right,B));
        }else {
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
    }

    public boolean isSameStructure(TreeNode A, TreeNode B) {

        if(A==null && B==null){
            return true;
        }else if(A!=null && B==null){
            return false;
        }else if(A==null && B!=null){
            return false;
        }

        if(A.val!=B.val){
            return false;
        }

        return  isSameStructure(A.left,B.left) && isSubStructure(A.right,B.right);
    }




    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int[] dp = new int[nums.length];

        int sum=nums[0];
        int max=nums[0];
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            if(sum>=0){
                dp[i]= Math.max(sum+nums[i],dp[i-1]);
                sum = sum+nums[i];
            }else {
                dp[i]= Math.max(nums[i],dp[i-1]);
                sum = nums[i];
            }
            max = Math.max(dp[i],max);
        }

        return dp[nums.length-1];
    }


    public int numWays(int n) {

        if(n<1){
            return 0;
        }

        if(n==1 || n==2){
            return n;
        }

        long  [] dp = new long  [n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }

        return (int)(dp[n]);
    }


    public int lengthOfLongestSubstring(String s) {


        if(s==null || s.length()==0){
            return 0;
        }

        // 永远保持最近的连续的字符串
        Map<String,Integer> strMap = new HashMap<>();
        int[] dp = new int[s.length()];
        int minIndex = 0;
        int max = 0;

        for(int i=0;i<s.length();i++){
            String curStr = s.substring(i, i + 1);
            if(!strMap.containsKey(curStr)){
                dp[i]= i-minIndex+1;
                strMap.put(curStr,i);
                max = Math.max(max,dp[i]);
            }else {
                Integer dulpIndex = strMap.get(curStr);
                if(dulpIndex<minIndex){
                    dp[i]= i-minIndex+1;
                    strMap.put(curStr,i);
                    max = Math.max(max,dp[i]);
                }else {
                    strMap.put(curStr,i);
                    minIndex= dulpIndex+1;
                }

            }
        }

        return max;
    }



    public int translateNum(int num) {

        if(num==0){
            return 1;
        }
        String data = String.valueOf(num);
        return translate(data);
    }


    public int translate(String data) {

        if(data==null || data.length()==0){
            return 1;
        }

        if(data.length()==1){
            return 1;
        }

        int sum = 0;
        String preTwo = data.substring(0, 2);
        if(Integer.parseInt(preTwo)<=25 && !preTwo.startsWith("0")){
            sum += translate(data.substring(2,data.length()));
        }
        sum += translate(data.substring(1,data.length()));
        return sum;
    }



    List<String> finalKuo = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateKuo("",n,n);
        return finalKuo;
    }


    void generateKuo(String curStr,int left,int right){
        if( left<0 || right<0 || left>right){
            return;
        }

        if(left==0 && right==0){
            finalKuo.add(curStr);
            return;
        }
        generateKuo(curStr+"(",left-1,right);
        generateKuo(curStr+")",left,right-1);
    }



    List<List<Integer>> pResult = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        boolean[] travel = new boolean[n];
        for (int i=0;i<n;i++){
            travel[i]= false;
        }

        permuteK(travel,nums,new ArrayList<>(),n);

        return pResult;
    }

    void permuteK(boolean[] travel,int[] nums,List<Integer> pathList,int n){

        boolean finished = true;
        for(int i=0;i<n;i++){
            if(!travel[i]){
                // 这个节点开始travel
                finished = false;
                travel[i]=true;
                pathList.add(nums[i]);
                permuteK(travel,nums,pathList,n);
                pathList.remove(pathList.size()-1);
                travel[i]=false;
            }
        }

        if(finished){
            pResult.add(new ArrayList<>(pathList));
        }
    }



    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode curNode = head;
        if(curNode.val==val){
            return curNode.next;
        }

        while(curNode.next!=null){
            if(curNode.next.val==val){
                ListNode next = curNode.next.next;
                curNode.next= next;
                break;
            }
            curNode=curNode.next;
        }
        return head;
    }


    int result = 0;
    public int movingCount(int m, int n, int k) {


        boolean[][] travel = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                travel[i][j]= false;
            }
        }
        moving(0,0,m,n,k,travel);
        return result;
    }


    public void moving(int i,int j,int m,int n,int k,boolean[][] travel){
        if(i<0 || j<0 || i>=m || j>=n  || travel[i][j]){
            return;
        }

        travel[i][j]=true;
        int vv= i/10+i%10+j/10+j%10;
        if(vv>k){
            return;
        }
        result++;
        moving(i+1,j,m,n,k,travel);
        moving(i,j+1,m,n,k,travel);
        moving(i-1,j,m,n,k,travel);
        moving(i,j-1,m,n,k,travel);
    }



    public int kthLargest(TreeNode root, int k) {

        if(root==null){
            return -1;
        }


        List<Integer> allData = new ArrayList<>();
        middleTravel(root,allData);

        int size = allData.size();
        if(k>size){
            return -1;
        }

        return allData.get(size-k);

    }

    void middleTravel(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        middleTravel(root.left,list);
        list.add(root.val);
        middleTravel(root.right,list);
    }


    TreeNode pre=null,head=null;

    public TreeNode treeToDoublyList(TreeNode root) {

        if(root==null){
            return null;
        }
        ddd(root);
        pre.right = head;
        return head;
    }

    public void ddd(TreeNode root){

        if(root==null){
            return;
        }
        TreeNode cc = root;
        ddd(root.left);
        // 处理关系
        if(pre==null){
            head = root;
            pre=root;
        }else {
            pre.right = root;
            root.left = pre;
            pre=root;
        }
        ddd(root.right);
    }


    public static int[] twoSum(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return new int[2];
        }

        int[] result = new int[2];
        int l=0,r=nums.length-1;

        while((l+1)<r){
            int mid= l+(r-l)/2;
            if(nums[mid]<target){
                l=mid;
            }else if(nums[mid]>target){
                r=mid;
            }else {
                break;
            }
        }

        r=Math.min(r,nums.length-1);

        l=0;
        while(l<r){
           if((nums[l]+nums[r])>target){
               r= r-1;
           }else if((nums[l]+nums[r])<target){
               l = l+1;
           }else {
               result[0]=nums[l];
               result[1]=nums[r];
               break;
           }
        }
        return result;
    }


    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public boolean isBalanced(TreeNode root) {

        if(root==null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return  isBalanced(root.left) && isBalanced(root.right);
    }

    boolean exitWord = false;
    public boolean exist(char[][] board, String word) {


        List<Character> characters = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            characters.add(word.charAt(i));
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] travel = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                travel[i][j]= false;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,m,n,travel,characters);
            }
        }
        return exitWord;
    }

    void dfs(char[][] board,int i,int j,int m,int n,boolean[][] travel,List<Character> characters){
        if(characters==null || characters.size()==0){
            exitWord=true;
            return;
        }
        if(i<0 || j<0 || i>=m || j>=n){
            return;
        }
        if(travel[i][j]){
            return;
        }
        if(board[i][j]!=characters.get(0)){
            return;
        }
        travel[i][j]=true;
        characters.remove(0);
        dfs(board,i+1,j,m,n,travel,characters);
        dfs(board,i,j+1,m,n,travel,characters);
        dfs(board,i-1,j,m,n,travel,characters);
        dfs(board,i,j-1,m,n,travel,characters);
        characters.add(0,board[i][j]);
        travel[i][j]=false;

    }


    List<List<Integer>> sumResult = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfsPathSum(root,target,new ArrayList<>());
        return sumResult;
    }

    public void dfsPathSum(TreeNode root,int target,List<Integer> path){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null && target==root.val ){
            path.add(target);
            sumResult.add(new ArrayList<>(path));
        }

        path.add(root.val);
        dfsPathSum(root.left,target-root.val,path);
        dfsPathSum(root.right,target-root.val,path);
        path.remove(path.size()-1);
    }


    public String reverseWords(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            String ss = s.substring(i,i+1);
            if(!" ".equals(ss)){
                sb.append(ss);
            }else {
                if(sb.length()>0){
                    stack.push(sb.toString());
                }
                sb = new StringBuilder();
            }
        }

        if(sb.length()>0){
            stack.push(sb.toString());
        }

        StringBuilder sbbb = new StringBuilder();

        while(!stack.isEmpty()){
            sbbb.append(stack.pop());
            if(!stack.isEmpty()){
                sbbb.append(" ");
            }
        }

        return sbbb.toString();
    }

    List<Integer> xPath = new ArrayList<>();
    List<Integer> yPath = new ArrayList<>();
    public  boolean isCousins(TreeNode root, int x, int y) {


        findPath(root,x,new ArrayList<>(),xPath);
        findPath(root,y,new ArrayList<>(),yPath);

        if(xPath.size()==yPath.size()){
            xPath.remove(xPath.size()-1);
            yPath.remove(yPath.size()-1);
            if(xPath.size()>0 && yPath.size()>0){
                return xPath.get(xPath.size()-1)!=yPath.get(yPath.size()-1);
            }
        }
        return false;
    }


     void findPath(TreeNode root,int num,List<Integer> path,List<Integer> retPath){
        if(root==null){
            return ;
        }
        path.add(root.val);

        if(root.val == num){
            retPath.addAll(new ArrayList<>(path));
            return;
        }

        findPath(root.left,num,path,retPath);
        findPath(root.right,num,path,retPath);
        path.remove(path.size()-1);
    }

}
