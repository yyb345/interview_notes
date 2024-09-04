package leetcode.niuke;

import leetcode.ListNode;
import leetcode.binarytree.TreeNode;

import java.util.Stack;
import java.util.*;

public class NiuKeProblem {

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


}
