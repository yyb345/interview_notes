package problems;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Map<TreeNode,TreeNode> parents=new HashMap<>();


    public static int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i=i+2){
            sum+=nums[i];
        }

        return  sum;
    }

    public static int completNum(int n){
        int m=0;
        String result = Integer.toBinaryString(n);
        int j=0;
        for(int i=result.length();i>0;i--){


            if(result.substring(i-1,i).equals("0"))
                m=m+(int)Math.pow(2,j);

               j++;

        }


        return m;
    }



    public static int hammingDistance(int x, int y) {

        int result=x ^ y;
        int distance=0;
        String xx= Integer.toBinaryString(result);
        for(int i=0;i<xx.length();i++){
            if(xx.charAt(i)=='1')
                distance++;
        }

        return distance;
    }






    public int distributeCandies(int[] candies) {

        Set hs = new HashSet();

        for(int candy: candies)
            hs.add(candy);

        if(hs.size()>=(candies.length/2))
            return candies.length/2;
        else
            return hs.size();
    }

//problem 463
    public int islandPerimeter(int[][] grid) {
        int length=0;
        int numland=0;
        int subNum=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]>0){
                numland++;
                if(i-1>=0){
                    if(grid[i-1][j]>0)
                        subNum++;
                }
                if(j-1>=0){
                    if(grid[i][j-1]>0)
                        subNum++;
                }
                if(i+1<grid.length){
                    if(grid[i+1][j]>0)
                        subNum++;
                }
                if(j+1<grid[0].length){
                    if(grid[i][j+1]>0)
                        subNum++;
                }


            }

        }

        length=4*numland-subNum;



        return length;
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {
        boolean is=true;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                if(i+1<matrix.length && j+1<matrix[0].length){
                    if(matrix[i][j]!=matrix[i+1][j+1]){
                        is=false;
                        break;
                    }
                }
        }


        return is;
    }

    public static  int calPoints(String[] ops) {
        int sum=0;
        int score[]=new int[ops.length];
        for(int i=0;i<ops.length;i++)
            if(ops[i].equals("+")){
                if(i-2>=0) {
                    int index1=0;
                    int index2=0;
                    for(int index=i-1;index>=0;index--){
                        if(score[index]!=0){
                            index1=index;
                            break;

                        }

                    }
                    for(int k=index1-1;k>=0;k--){
                        if(score[k]!=0){
                            index2=k;
                            break;
                        }

                    }
                    score[i]=score[index1]+score[index2];

                }

            }else if(ops[i].equals("D")){
                if(i-1>=0) {
                    int index1=0;
                    for(int index=i-1;index>=0;index--){
                        if(score[index]!=0){
                            index1=index;
                            break;

                        }

                    }

                    score[i]=score[index1]*2;

                }

            }else if(ops[i].equals("C")){
                if(i-1>=0) {

                    int index1=0;
                    for(int index=i-1;index>=0;index--){
                        if(score[index]!=0){
                            index1=index;
                            break;

                        }

                    }
                    score[index1]=0;
                    score[i]=0;

                }


            }else{
                score[i]=Integer.parseInt(ops[i]);

            }

            for(int it=0;it<score.length;it++)
                sum+=score[it];

        return sum;
    }

    //problem 566
    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int sumElement=nums.length*nums[0].length;
        int reshape[][]=new int[r][c];
        if((r*c)!=sumElement){
            return nums;
        }

        else{
            int rowNum=0;
            int colNum=0;
            int iteration=0;
            for(int i=0;i<nums.length;i++)
                for(int j=0;j<nums[0].length;j++){
                    reshape[rowNum][iteration%c]=nums[i][j];
                    iteration++;
                    if(iteration%c==0) {
                        rowNum++;
                    }
                    colNum++;

                }

                return reshape;

        }

    }

    //problem 500
    public static  String[] findWords(String[] words) {
        String []keybord=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        ArrayList<String> matchWords = new ArrayList<String>();
        for(String word:words){
            boolean inkey=true;
            for(String key:keybord){
                inkey=true;
                for(int i=0;i<word.length() && inkey;i++){
                    if(!key.contains(word.substring(i,i+1).toLowerCase())){
                        inkey=false;
                    }



                }
                if(inkey){
                    matchWords.add(word);
                    break;
                }

            }


        }

        String []matchWords1=new String[matchWords.size()];
        for(int k=0;k<matchWords.size();k++)
            matchWords1[k]=matchWords.get(k);


            return matchWords1;
    }


    // problem 338
    public static int[] countBits(int num) {

        int[] result=new int[num+1];

        if(num>0){




            result[0]=0;
            result[1]=1;

            for(int i=2;i<=num;i++){
                if(i%2==0){
                    result[i]=result[i/2];
                }else{
                    result[i]=result[i-1]+1;
                }
            }

            return result;


        }else{
            result[0]=0;
            return result;
        }


    }


    // problem 791

    public static String customSortString(String S, String T) {

        String result="";
        Map<String,Integer> a =new HashMap<String,Integer>();
        for(int i=0;i<T.length();i++){
            String tmp=T.substring(i,i+1);
            if(S.contains(tmp)){
                if(a.containsKey(tmp))
                    a.put(tmp,a.get(tmp)+1);
                else
                    a.put(tmp,1);

            }else{
                result=result+tmp;
            }



        }
        for(int j=0;j<S.length();j++){
            String tmp1=S.substring(j,j+1);
            if(a.get(tmp1)!=null){
                for(int k=0;k<a.get(tmp1);k++)
                {
                    result=result+tmp1;
                }
            }


        }
        return result;

    }


    // problem 841

    public static  boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean all=true;
        Stack<Integer> s=new Stack<>();
        int[] array=new int[rooms.size()];

        int k=0;
        List<Integer> keys=rooms.get(k++);
        for(int j=0;j<keys.size();j++) {
            int key = keys.get(j);
            s.push(key);
        }
        array[0]=1;


        while(!s.empty()){
                    int room=s.pop();
                    array[room]=1;
                    List<Integer> keys11=rooms.get(room);
                    for(int j=0;j<keys11.size();j++) {
                        int key = keys11.get(j);
                        if(array[key]==0)
                            s.push(key);
                    }

        }

        for(int arr:array){
            if(arr==0){
                all=false;
                break;
            }

        }

        return all;
    }


    //problem 647
    public static int countSubstrings(String s) {

        int count=0;

        if(s.length()>1){
            String next=s.substring(0,s.length()-1);
            int sum=0;

            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i+1))
                    sum=sum+1;
                else
                    break;
            }

            count=sum+1+countSubstrings(next);

        }else
            count=1;


        return count;

    }


// problem 540
    public static int singleNonDuplicate(int[] nums) {
        int uniq=0;
        for(int num:nums)
            uniq=uniq^num;

        return uniq;
}

// proble 451
  public static String frequencySort(String s) {
        HashMap<String,Integer> bucket=new HashMap<String, Integer>();

        for(int i=0;i<s.length();i++){
            String tmp=s.substring(i,i+1);
            if(bucket.containsKey(tmp)){
                bucket.put(tmp,bucket.get(tmp)+1);
            }else{
                bucket.put(tmp,1);
            }
        }

      List<Map.Entry<String, Integer>> listMap=bucket.entrySet().stream()
              .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
              .collect(Collectors.toList());

//      PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
//              new Comparator<Map.Entry<Character, Integer>>() {
//                  @Override
//                  public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
//                      return b.getValue() - a.getValue();
//                  }
//              }
//      );

      StringBuilder result=new StringBuilder();
      for(Map.Entry<String,Integer> e:listMap){
          int freq=e.getValue();
          String ss=e.getKey();
          for(int k=0;k<freq;k++)
              //result=result+""+ss;
              result.append(ss);
      }


        return result.toString();
}


//problem 526
    public static int countArrangement(int N) {
        int totalMatchNum=0;

        boolean array[]=new boolean[N+1];
        for(int i=0;i<N+1;i++){
            array[i]=true;
        }
        totalMatchNum=countArr(1,N,array);
        return totalMatchNum;
    }

    public static int countArr(int start,int N,boolean array[]){

        int index=start;
        int sum=0;
        if(start==N) {
            for (int i = 1; i <= N; i++) {
                if (array[i]) {
                    int value = i;
                    if (value % index == 0 || index % value == 0) {
                        sum = 1;

                    } else {
                        sum = 0;
                    }
                }
            }
        }else{
            for(int i=1;i<=N;i++){
                if(array[i]){
                    int value=i;
                    if(value%index==0 || index%value==0){
                        array[i]=false;
                        sum+=countArr(index+1,N,array);
                        array[i]=true;

                    }

                }
            }

        }


       return sum;

    }



// problem 347

//    public static List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> result=new ArrayList<>();
//
//
//
//        return result;
//    }


    // problem tjw
    public static Map<Boolean,String> tjw(int m,int n){



        Map<Boolean,String> result=new HashMap<>();

        int avg=m/n;
        boolean exits=false;
        Map<Integer,Integer> fbsums=new HashMap<>();
        fbsums.put(1,1);
        fbsums.put(2,2);
        int a1=1;
        int a2=1;
        int fbsum=2;
        int index=2;
        while(fbsum<=avg){
            int tmp2=a2;
            int tmp1=a1;
            a1=tmp2;
            a2=tmp1+tmp2;
            fbsum=fbsum+a2;
            fbsums.put(index++,fbsum);
        }

        if(n==1){
            if(fbsums.containsKey(m)){
                result.put(true,"1");

            }else{
                result.put(false,"0");
            }

            return result;
        }else{
            int sum=0;
            int key=0;
            Map<Boolean, String> rr=new HashMap<>();
            for(Map.Entry<Integer,Integer> entry:fbsums.entrySet()){
                sum=entry.getValue();
                key=entry.getKey();
                rr= tjw(m - sum, n - 1);
                //如果成功
                if(rr.containsKey(true)){
                    exits=true;
                    break;
                }
            }

            if(exits){
                result.put(true,rr.get(true)+","+key);

            }else{
                result.put(false,"0");
            }


            return result;
        }


    }

//    public class TreeNode{
//        int a;
//        int b;
//        int value;
//        String xiazhu;
//        List<String> path;
//        TreeNode leftNode;
//        TreeNode rightNode;
//        public TreeNode(){
//        }
//        public TreeNode(int a,int b,int value,String xiazhu){
//            this.a = a;
//            this.b=b;
//            this.xiazhu=xiazhu;
//            this.value=value;
//            this.leftNode = null;
//            this.rightNode = null;
//            this.path=null;
//        }
//    }

//    public  TreeNode jingsai(int a, int b,int value,String xiazhu){
//
//
//        TreeNode current=new TreeNode(a,b,value,xiazhu);
//        List<String> path=new ArrayList<>();
//        if(a+b>7){
//            return null;
//        } else{
//
//            if(a+b==7){
//                if(a>=4 && value==2000){
//                    String result=xiazhu;
//                    path.add(result);
//                }
//                if(b>=4 && value==0){
//                    String result=xiazhu;
//                    path.add(result);
//                  }
//
//                current.path=path;
//
//            }
//
//
//            int iters=value/1000;
//            for(int i=0;i<iters;i++){
//                int xiazhuValue=1000+i*1000;
//                int huibaoValue=(xiazhuValue)*2;
//                int currentValue=value-xiazhuValue+huibaoValue;
//                String nextXiazhu=xiazhu+"(a,"+xiazhuValue+")";
//                current.leftNode=jingsai(a+1,b,currentValue,nextXiazhu);
//            }
//
//            for(int i=0;i<iters;i++){
//                int xiazhuValue=i*1000;
//                int huibaoValue=0;
//                int currentValue=value-xiazhuValue+huibaoValue;
//                String nextXiazhu=xiazhu+"(b,"+xiazhuValue+")";
//                current.rightNode=jingsai(a,b+1,currentValue,nextXiazhu);
//            }
//
//            if(current.leftNode!=null){
//                for(String p:current.leftNode.path)
//                    path.add(p);
//            }
//            if(current.rightNode!=null){
//                for(String p:current.rightNode.path)
//                    path.add(p);
//            }
//            current.path=path;
//            return current;
//        }
//
//    }




    //problem 856

    public static  int scoreOfParentheses(String S) {

        int sum=0;
        Stack<Character> tmp=new Stack<>();
        Stack<Character> tmpvalue=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                tmp.push('(');
                tmpvalue.push('(');
            }else if(S.charAt(i)==')'){
                tmp.pop();
                Character popvalue = tmpvalue.pop();

                if(popvalue!=null) {
                       int prevalue=0;
                       if(popvalue=='('){
                           prevalue=1;
                           tmpvalue.push('1');
                       }else {
                           Character pop1 = tmpvalue.pop();

                           if(pop1=='('){
                               int value=(Integer.parseInt(popvalue.toString())*2);
                               tmpvalue.push((char)value);
                           }else{
                               int value=Integer.parseInt(popvalue.toString())+Integer.parseInt(pop1.toString());
                               tmpvalue.push((char)value);
                           }
                       }

                   }
                }

                if(tmp.size()==0){
                    Character pop = tmpvalue.pop();
                    sum=Integer.parseInt(pop.toString());
                }

            }
        return sum;
    }


    // problem 169

    public static  int majorityElement(int[] nums) {

        Map<Integer,Integer> tmp=new HashMap<>();
        for(int num:nums){
            if(tmp.containsKey(num))
                tmp.put(num,tmp.get(num)+1);
            else
                tmp.put(num,1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : tmp.entrySet()){
            list.add(entry); //将map中的元素放入list中
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

            @Override

            public int compare(Map.Entry<Integer, Integer> ele1,

                               Map.Entry<Integer, Integer> ele2) {

                return ele1.getValue().compareTo(ele2.getValue());

            }

        });

        return list.get(list.size()-1).getKey();


    }


    static  class KV{
        int key;
        int value;
        KV(int key,int value){
            this.key=key;
            this.value=value;
        }

    }

    //problem 739
    public static int[] dailyTemperatures(int[] T) {
        int []result=new int[T.length];

        List<Integer> key=new ArrayList<>();
        List<Integer> value= new ArrayList<>();
        List<Integer> index=new ArrayList<>();

        int currentValue=T[0];
        for(int i=1;i<T.length;i++){
//            for(int k=0;k<value.size();k++){
//                value.set(k,value.get(k)+1);
//            }

            if(currentValue>=T[i]){
              key.add(currentValue);
              value.add(1);
              index.add(i-1);
            }else if(currentValue<T[i]){
                result[i-1]=1;
                while(key.size()>0){
                    int pop=key.get(key.size()-1);
                    if(pop<T[i]){
                        result[index.get(index.size()-1)]=value.get(key.size()-1);
                        result[index.get(index.size()-1)]=i-(index.get(index.size()-1));
                        key.remove(key.size()-1);
                        value.remove(value.size()-1);
                        index.remove(index.size()-1);
                    }else{
                        break;
                    }
                }


            }

            currentValue=T[i];
        }


        while(index.size()>0){
            result[index.get(index.size()-1)]=0;
            index.remove(index.size()-1);
        }

        return result;
    }


    //problem 669



      public static  class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public static TreeNode trimBST(TreeNode root, int L, int R) {

        int value=root.val;

        TreeNode newRoot=null;
        if(value>=L && value<=R){
             newRoot=new TreeNode(value);
            if(root.left!=null)
                newRoot.left=trimBST(root.left,L,R);
            if(root.right!=null)
                newRoot.right=trimBST(root.right,L,R);

        }else if(value<L){
            if(root.right!=null){
                newRoot=trimBST(root.right,L,R);
            }

        }else if(value>R){
            if(root.left!=null){
                newRoot=trimBST(root.left,L,R);
            }

        }


        return newRoot;

    }

    public static void printTreeNode(TreeNode root){

        System.out.print(root.val+",");
        if(root.left!=null)
            System.out.print(root.left.val+",");
        else
            System.out.print("null,");
        if(root.right!=null)
            System.out.print(root.right.val+",");
        else
            System.out.print("null,");
    }


    // problem 946

    public static  boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> push=new Stack<>();
        int pushIndex=0;
        int popIndex=0;
        boolean pushStop=false;

        while(!pushStop){
            int currentValue;
            if(push.size()==0){
                if(pushIndex<pushed.length){
                    push.push(pushed[pushIndex]);
                    pushIndex++;
                }

            }else {
                    currentValue=push.peek();
                    if(popIndex<popped.length){
                        if(currentValue==popped[popIndex]){
                            push.pop();
                            popIndex++;
                        }else{
                            if(pushIndex<pushed.length){
                                push.push(pushed[pushIndex]);
                                pushIndex++;

                            }
                        }
                    }
                }
            if(pushIndex==pushed.length)
                pushStop=true;
        }

        if(push.size()==0)
            return true;
        else {
            while(popIndex<popped.length){
                int popvalue=push.pop();
                if(popvalue==popped[popIndex])
                    popIndex++;
                else
                    break;
            }

            if(push.size()==0)
                return true;
            else
                return false;
        }



    }

    // problem 144
    public static  List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        Stack<String> status=new Stack<>();
        Stack<Boolean> finish=new Stack<>();
        stack.push(root);
        status.push("L");
        finish.push(false);

        result.add(root.val);


        while(stack.size()>0 ){


            TreeNode current=stack.peek();
            String currentStatus=status.peek();

            if(currentStatus.equals("L")){
                if(current.left!=null){
                    stack.push(current.left);
                    status.push("L");
                    result.add(current.left.val);
                    finish.push(false);
                }else{

                    status.pop();
                    status.push("R");

                }
            }else if(currentStatus.equals("R")){
                    if(current.right!=null){
                        stack.push(current.right);
                        status.push("L");
                        result.add(current.right.val);
                        finish.push(false);
                    }else{
                        status.pop();
                        stack.pop();
                        //右边已结束
                        status.pop();
                        status.push("R");
                        finish.pop();
                        finish.push(true);
                    }
                   if(stack.size()==1 && finish.peek()){
                        stack.pop();
                   }


            }
        }




        return result;
    }



    // problem 287

    public static int findDuplicate(int[] nums) {

        int uniqNumber;

        int N=nums.length-1;
        int sum=N*(N+1)/2;
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        uniqNumber=totalSum-sum;
        return uniqNumber;
    }

    // problem 844
    public static  boolean backspaceCompare(String S, String T) {
        boolean result=true;
        Stack<Character> stackS=new Stack<>();
        Stack<Character> stackT=new Stack<>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(stackS.size()>0){
                    stackS.pop();
                }
            }else {
                stackS.push(S.charAt(i));
            }
        }
        for(int j=0;j<T.length();j++){
            if(T.charAt(j)=='#'){
                if(stackT.size()>0){
                    stackT.pop();
                }
            }else {
                stackT.push(T.charAt(j));
            }
        }



        if(stackS.size()!=stackT.size()){
            result=false;
        } else{
            if(stackS.size()==0){
                result=true;
            }else{
                while(stackS.size()>0){
                    Character popS = stackS.pop();
                    Character popT = stackT.pop();
                    if(!popS.equals(popT)){
                        result=false;
                        break;
                    }

                }
            }

        }


        return result;
    }


    // problem 897

    public TreeNode increasingBST(TreeNode root) {

        Stack<TreeNode> travel=new Stack<>();
        List<Integer> inOrder=new ArrayList<>();
        TreeNode p=root;
        while(travel.size()>0 || p!=null){
            if(p!=null){
                travel.push(p);
                p=p.left;
            }else{

                TreeNode preRoot=travel.pop();
                inOrder.add(preRoot.val);
                p=preRoot.right;
            }
        }

        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: inOrder) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList();

        if(root==null)
            return result;

        if(root.left!=null){
            List<String> strings = binaryTreePaths(root.left);
            result.addAll(strings);
        }
        if(root.right!=null){
            List<String> strings = binaryTreePaths(root.right);
            result.addAll(strings);
        }

        if(root.left==null && root.right==null){
            result.add(""+root.val);

        } else{
            for(int j=0;j<result.size();j++){
                String s = root.val+"->"+result.get(j);
                result.set(j,s);
            }
        }

        return result;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> container=new Stack<>();
        TreeNode iter=root;

        while(container.size()>0 || iter!=null){

            if(iter!=null){
                container.push(iter);
                iter=iter.left;
            }else{
                TreeNode treeNode=container.pop();
                result.add(treeNode.val);
                iter=treeNode.right;
            }
        }

        return result;

    }

    // 404. Sum of Left Leaves
    public static int sumOfLeftLeaves(TreeNode root) {
        int result=0;

        if(root==null){

        }else{
            if(root.left!=null){
                if(root.left.left==null && root.left.right==null){
                    result=root.left.val;
                }else {
                    result+=sumOfLeftLeaves(root.left);
                }

            }
            if(root.right!=null){
                result+=sumOfLeftLeaves(root.right);

            }
        }


        return result;
    }


    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result=new ArrayList();

        int subTotal=N-1;
        int i=0;
        int left=0;
        int right=0;


        if(N==1){
            TreeNode tmp=new TreeNode(0);
            result.add(tmp);
        }else{
            while(left<subTotal){

                left=2*i+1;
                right=subTotal-left;
                List<TreeNode> leftTreeNodes=allPossibleFBT(left);
                List<TreeNode> rightTreeNodes=allPossibleFBT(right);

                for(TreeNode l:leftTreeNodes){
                    for(TreeNode r:rightTreeNodes){
                        TreeNode tmp=new TreeNode(0);
                        tmp.left=l;
                        tmp.right=r;
                        result.add(tmp);
                    }
                }
                i++;
                left=2*i+1;
            }
        }



        return result;




    }


    // problem  121
    public  static int maxProfit(int[] prices) {

        if(prices.length>1){
            int []tmp=new int[prices.length-1];
            for(int i=0;i<prices.length-1;i++){
                tmp[i]=prices[i];
            }

            int min = Arrays.stream(tmp).min().getAsInt();
            int value = Math.max((prices[prices.length - 1] - min), maxProfit(tmp));
            return value;
        }else {
            int value=0;
            return value;
        }




    }



    public static  List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> treeNode=new LinkedList<>();
        Queue<TreeNode> tree2=new LinkedList<>();
        Queue<TreeNode> tmp=new LinkedList<>();
        List<Integer> result=new ArrayList<>();

        if(root!=null){

            treeNode.add(root);
            while(treeNode.size()>0){

                int maxValue=Integer.MIN_VALUE;
                boolean yes=false;

                while(treeNode.size()>0){
                    TreeNode pop = treeNode.poll();
                    if(pop!=null){
                        if(pop.left!=null){
                            tree2.add(pop.left);
                        }
                        if(pop.right!=null){
                            tree2.add(pop.right);
                        }
                        if(pop.val>maxValue){
                            maxValue=pop.val;
                            yes=true;
                        }
                    }



                }
                if(yes){
                    result.add(maxValue);
                }
                treeNode=tree2;
                tree2=new LinkedList<>();
            }


        }



        return result;



    }


    static class Result{
         List<Integer> result;
         int sum;
    }

    public static  int[] findFrequentTreeSum(TreeNode root) {



        if(root!=null){
            Result result=subTreeSum(root);
            List<Integer> collect = result.result;
            List<Integer> finalResult=new ArrayList<>();
            Map<Integer,Integer> freq=new HashMap<>();
            int MAX=1;
            for(int sum:collect){
                if(freq.containsKey(sum)){
                    int newValue=freq.get(sum)+1;
                    if(newValue>=MAX)
                        MAX=newValue;
                    freq.put(sum,newValue);
                }else{
                    freq.put(sum,1);
                }
            }

            for(Map.Entry<Integer,Integer> a:freq.entrySet()){
                if(a.getValue()==MAX){
                    finalResult.add(a.getKey());
                }
            }
            int[] array = finalResult.stream().mapToInt(i->i).toArray();
            return array;
        }else{
            int[] array=new int[]{};
            return array;
        }

    }


//    public static int[] twoSum(int[] nums, int target) {
//        List<Integer> data=new ArrayList<>();
//        for(int num:nums){
//            if(nums.)
//        }
//
//    }

    public static Result subTreeSum(TreeNode root){

        Result result=new Result();
        if(root!=null){
            List<Integer> tmp=new ArrayList<>();
            int leftSum,rightSum;
            if(root.left!=null){
                Result left = subTreeSum(root.left);
                List<Integer> leftList = left.result;
                tmp.addAll(leftList);
                leftSum=left.sum;
            }else {
               leftSum=0;
            }
            if(root.right!=null){
                Result right = subTreeSum(root.right);
                List<Integer> rightList = right.result;
                tmp.addAll(rightList);
                rightSum=right.sum;
            }else{
                rightSum=0;
            }

            result.sum=leftSum+rightSum+root.val;
            if(root.left==null && root.right==null){
                tmp.add(root.val);
            }else{
                tmp.add(result.sum);
            }

            result.result=tmp;
        }

        return result;
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length>0){
            int[] subNums=new int[nums.length-1];
            int lasstElement=nums[nums.length-1];
            for(int i=0;i<subNums.length;i++){
                subNums[i]=nums[i];
            }
            List<List<Integer>> subDatas = subsets(subNums);
            result.addAll(subDatas);

            for(List<Integer> set:subDatas){
                List<Integer> subb=new ArrayList<>();
                subb.addAll(set);
                subb.add(lasstElement);
                result.add(subb);
            }


        }else{
            result.add(new ArrayList<>());
        }

        return result;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> tmp=new LinkedList<>();
        if (root != null) {
            tmp.add(root);
            while(tmp.size()>0){
                List<Integer> dataList=new ArrayList<>();
                //每层有多少个节点
               int levelNum=tmp.size();
               for(int i=0;i<levelNum;i++){
                   TreeNode data = tmp.poll();
                   dataList.add(data.val);
                   if(data.left!=null){
                       tmp.add(data.left);
                   }
                   if(data.right!=null){
                       tmp.add(data.right);
                   }
               }
               result.add(dataList);
            }
        }

        return result;
    }

//    public static int[] productExceptSelf(int[] nums) {
//        int sum=1;
//        int[] result=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            result[i]=1;
//        }
//
//        for(int i=1;i<nums.length;i++){
//            int currentElement=nums[i];
//            for(int j=0;j<i;j++){
//
//            }
//        }
//
//    }

    public static  List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else{
                hashMap.put(num,0);
            }
        }
        //构建最小堆
        PriorityQueue<Integer> queue=new PriorityQueue((n1,n2)->hashMap.get(n1)-hashMap.get(n2));

        for(Map.Entry<Integer, Integer> keys:hashMap.entrySet()){
            queue.add(keys.getKey());
            if(queue.size()>k){
                queue.poll();
            }
        // 输出最终形式
            while(queue.size()>0){
                result.add(queue.poll());
            }
            Collections.reverse(result);

            return result;
        }



        return result;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        if(nums.length>1){
            for(int i=0;i<nums.length;i++){
                int[] subNums=new int[nums.length-1];
                int index=0;
                for(int j=0;j<nums.length;j++){
                    if(i!=j){
                        subNums[index++]=nums[j];
                    }
                }
                List<List<Integer>> permute = permute(subNums);
                for(List<Integer> d:permute){
                    d.add(nums[i]);
                    result.add(d);
                }
            }
        }else if(nums.length==1){
            List<Integer> dd=new ArrayList<>();
            dd.add(nums[0]);
            result.add(dd);
        }


        return result;
    }


    public static List<String> generateParenthesis(int n) {

        List<String> result=new ArrayList<>();
        List<String> strings = subGenet(n - 1, n);
        for(String l:strings){
            result.add("("+l);
        }
        return result;
    }
    public static List<String> subGenet(int left,int right){
        List<String> result=new ArrayList<>();
        int leftRemaining=left;
        int rightRemaining=right;

            if(leftRemaining>0 && rightRemaining>0){
                // 一条路径 C
                List<String> leftStrings = subGenet(leftRemaining - 1, rightRemaining);
                for(String l:leftStrings){
                    result.add("("+l);
                }
                //另一条路径 )
                if(rightRemaining>leftRemaining){
                    List<String> rightStrings = subGenet( leftRemaining, rightRemaining - 1);
                    for(String r:rightStrings){
                        result.add(")"+r);
                    }
                }

            }else if(leftRemaining==0 && rightRemaining>0) {

                // 一条路径，)
                List<String> rightStrings = subGenet(leftRemaining, rightRemaining - 1);
                for (String r : rightStrings) {
                    result.add(")" + r);
                }
            } else if(leftRemaining==0 && rightRemaining==0){
                    result.add("");
                }




        return result;

    }

      public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static  ListNode oddEvenList(ListNode head) {
       if(head!=null){
           ListNode odd=head;
           ListNode even=head.next;
           ListNode startOdd=odd;
           ListNode startEven=even;

           while(odd!=null && even!=null){
               // 下一次迭代
               ListNode nextOdd=null;
               ListNode nextEven=null;
               if(odd.next!=null){
                   nextOdd=odd.next.next;
                   odd.next=odd.next.next;
               }else{
                   break;
               }

               if(even.next!=null){
                   nextEven=even.next.next;
                   even.next=even.next.next;
               }else{
                   break;
               }

               odd=nextOdd;
               even=nextEven;
           }



           odd.next=startEven;
           return startOdd;
       }else{
           return null;
       }





    }


    public  static  int kthSmallest(TreeNode root, int k) {

        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> values=new ArrayList<>();
        while(queue.size()>0){
            TreeNode poll = queue.poll();
            if(poll.left!=null){
                queue.add(poll.left);
                values.add(poll.val);
            }
            if(poll.right!=null){
                queue.add(poll.right);
                values.add(poll.val);
            }
        }
        Object[] objects = values.toArray();
        Arrays.sort(objects);
        int object =(int) objects[k - 1];

        result=object;

        return result;
    }

    public static int findKthLargest(int[] nums, int k) {

        Comparator cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        };

        Queue<Integer> queue=new PriorityQueue<Integer>(k,cmp);
        for(int i=0;i<k;i++){
           queue.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            Integer peek = queue.peek();
            if(nums[i]>peek){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        int objects = (int)queue.toArray()[0];

        return objects;


    }

    public  boolean equals(String a,String b){
        leetcodeString aa=new leetcodeString(a);
        leetcodeString bb=new leetcodeString(b);
        boolean equals = aa.equals(bb);
        return equals;
    }


    class leetcodeString{
        leetcodeString(String s){
            a=s;
        }
        String a;

        @Override
        public int hashCode() {
            int sum=0;
            char[] chars = a.toCharArray();
            for(char c:chars){
                sum+=(c-'a');
            }
            return sum;
        }
        @Override
        public boolean equals(Object obj) {
            String b=((leetcodeString)obj).a;
            boolean reult=false;
            if(this.a.length()==b.length()){
                Map<Character,Integer> tmpA=new HashMap();
                Map<Character,Integer> tmpB=new HashMap();
                for(int i=0;i<this.a.length();i++){
                    if(tmpA.containsKey(this.a.charAt(i))){
                        tmpA.put(this.a.charAt(i),tmpA.get(this.a.charAt(i))+1);
                    }else{
                        tmpA.put(this.a.charAt(i),1);
                    }
                }
                for(int i=0;i<b.length();i++){
                    if(tmpB.containsKey(b.charAt(i))){
                        tmpB.put(b.charAt(i),tmpB.get(b.charAt(i))+1);
                    }else{
                        tmpB.put(b.charAt(i),1);
                    }
                }

                for(Map.Entry<Character,Integer> data:tmpA.entrySet()){
                    if(tmpB.containsKey(data.getKey()) && (tmpB.get(data.getKey())-data.getValue()==0)){
                        reult=true;
                    }else{
                        reult=false;
                        break;
                    }
                }

            }
            return reult;
        }
    }





    public  List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ssa = s.toCharArray();
            Arrays.sort(ssa);
            String ss = String.valueOf(ssa);
            if(map.containsKey(ss)){
               List<String> strings = map.get(ss);
               strings.add(s);
               map.put(ss,strings);
           }else{
               List<String> list=new ArrayList<>();
               list.add(s);
               map.put(ss,list);
           }
        }

        for(Map.Entry<String,List<String>> m:map.entrySet()){
            result.add(m.getValue());
        }

        return result;
    }

    public Map<leetcodeString,List<String>> xxxxx(String[] strs){
        Map<leetcodeString,List<String>> map=new HashMap<>();
        for(String s:strs){
            leetcodeString ss=new leetcodeString(s);
            if(map.containsKey(ss)){
                List<String> strings = map.get(ss);
                strings.add(s);
                map.put(ss,strings);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(ss,list);
            }
        }

        return map;
    }

    public static int  findBottomLeftValue(TreeNode root) {

        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode pop = queue.poll();
                if(i==0){
                    result=pop.val;
                }
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }


        }


        return result;
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        int middleIndex=(nums.length-1)/2;

        if(middleIndex>0){
            int[] left=new int[middleIndex];
            int[] right=new int[nums.length-middleIndex-1];
            for(int i=0;i<middleIndex;i++){
                left[i]=nums[i];
            }
            for(int i=middleIndex+1;i<nums.length;i++){
                right[i]=nums[i];
            }
            TreeNode result=new TreeNode(nums[middleIndex]);
            result.left=sortedArrayToBST(left);
            result.right=sortedArrayToBST(right);
            return result;

        }else{
            TreeNode result=new TreeNode(nums[middleIndex]);
            return result;
        }


    }

    public static boolean isPalindrome(ListNode head) {
        boolean result=true;
        ListNode first=head;
        ListNode second=head;

        if(head!=null){
            ListNode reverse=new ListNode(head.val);
            while(second!=null && second.next!=null){

                first=first.next;
                second=second.next.next;
                //逆转链表
                ListNode tmp=reverse;
                ListNode newTmp=new ListNode(first.val);
                newTmp.next=tmp;
//            newTmp.val=first.val;
                reverse=newTmp;
            }
            ListNode left,right;
            if(second!=null){
                left=reverse;
                right=first;
            }else{
                left=reverse.next;
                right=first;
            }

            while(right!=null){
                if(left.val!=right.val){
                    result=false;
                    break;
                }
                left=left.next;
                right=right.next;
            }

        }

        return result;

    }


    public static ListNode deleteDuplicates(ListNode head) {



        if(head!=null){
            ListNode pre=head;
            ListNode iter=head.next;
//            Set<Integer> set=new HashSet<>();
//            set.add(head.val);
            //ListNode pre=head;
            while(iter!=null){
                if(pre.val==iter.val){
                    pre.next=iter.next;
                    iter=iter.next;
                }else{
                    pre=pre.next;
                    iter=iter.next;
                }
            }
        }


        return  head;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first=null;
        //ListNode result=null;
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }

        int preSum=0;

        while(stack2.size()>0 || stack1.size()>0){

            int sum=0;
            if(stack1.size()>0){
                sum+=stack1.pop();
            }
            if(stack2.size()>0){
                sum+=stack2.pop();
            }
            sum+=preSum;
            int value=sum%10;
            preSum=sum/10;
            ListNode tmp=new ListNode(value);
            tmp.next=first;
            first=tmp;
        }

        if(preSum==1){
            ListNode tmp=new ListNode(1);
            tmp.next=first;
            first=tmp;
        }

        return first;

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head!=null){

            ListNode iter=head;
            ListNode second=head;
            ListNode pre=head;

            int i=1;
            while(second!=null && i<n){
                second=second.next;
                i++;
            }


            int j=0;
            while(second!=null && second.next!=null){
                second=second.next;
                iter=iter.next;

                if(j>0){

                    pre=pre.next;
                }
                else
                  j++;
            }
            if(j>0)
                pre.next=iter.next;
            else
                head=head.next;
        }


        return head ;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode iter=head;
        ListNode pre=null;
        ListNode middle=null;
        ListNode tail=null;
        int index=1;
        while(iter!=null){
            if(index==m-1){
                pre=iter;
            }

            if(index>=m && index<=n){
                ListNode tmp=new ListNode(iter.val);
                tmp.next=middle;
                middle=tmp;
                if(index==m){
                    tail=middle;
                }
            }

            if(index==n+1){
                break;
            }


            iter=iter.next;
            index++;

        }

        if(pre!=null){
            pre.next=middle;
        }else{
            head=middle;
        }
        tail.next=iter;

        return head;

    }


    public static boolean isAnagram(String s, String t) {
        boolean result=true;
        Map<Character,Integer> s1=new HashMap();
        Map<Character,Integer> t1=new HashMap();

       for(int i=0;i<s.length();i++){
           if(s1.containsKey(s.charAt(i))){
               s1.put(s.charAt(i),s1.get(s.charAt(i))+1);
           }else {
               s1.put(s.charAt(i),1);
           }
       }

       for(int i=0;i<t.length();i++) {
           if (t1.containsKey(t.charAt(i))) {
               t1.put(t.charAt(i), t1.get(t.charAt(i)) + 1);
           } else {
               t1.put(t.charAt(i), 1);
           }
       }
       if(s1.size()>=t1.size()){
           for(Map.Entry<Character,Integer> ss:s1.entrySet()){
               if(t1.getOrDefault(ss.getKey(), 0)!=(int)ss.getValue()){
                   result=false;
                   break;
               }
           }
       }else{

               for(Map.Entry<Character,Integer> tt:t1.entrySet()){
                   if(s1.getOrDefault(tt.getKey(), 0)!=(int)tt.getValue()){
                       result=false;
                       break;
                   }
               }
       }



          return result;

    }

    public static  int search(int[] nums, int target) {

        int result=-1;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int middle=(start+end)/2;
            if(nums[middle]>target){
                end=middle-1;
            }else if(nums[middle]<target){
                start=middle+1;
            }else if(nums[middle]==target){
                result=middle;
                break;
            }
        }

        return result;

    }

    public static int searchInsert(int[] nums, int target) {

        int result=0;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int middle=(start+end)/2;
            if(nums[middle]>target){
                end=middle-1;
            }else if(nums[middle]<target){
                start=middle+1;
            }else if(nums[middle]==target){
                result=middle;
                break;
            }
        }
        result=start;

        return result;


    }

    public static  int firstUniqChar(String s) {
        int index=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,0);
            }
        }

        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(map.get(c)==0){
                index=i;
                break;
            }
        }

        return index;
    }

    public static int longestPalindrome(String s) {

        int result=0;
        if(s.length()>0){
            int[]  values=new int[26];
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                values[c - 'a']+=1;
            }
            int count1=0;
            int count2=0;
            for(int j=0;j<values.length;j++){
                if(values[j]>0){
                    if(values[j]==1){
                        count1++;
                    }else{
                        count2+=(values[j]/2);
                    }
                }
            }

            if(count1>0)
                result+=1;
            result+=(count2*2);

        }else{
            result=0;
        }


        return result;
    }

    public char findTheDifference(String s, String t) {
        char result=' ';
        Map<Character,Integer> map=new HashMap<>();

        if(s.length()>0){
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }
            for(int j=0;j<t.length();j++){
                char c = t.charAt(j);
                if(map.containsKey(c)){
                   map.put(c,map.get(c)-1);
                }else {
                    result=c;
                    break;
                }
            }

            for(Map.Entry<Character,Integer> a:map.entrySet()){
                if(a.getValue()==1){
                    result=a.getKey();
                    break;
                }
            }

        }else {
            result=t.charAt(0);
        }


        return result;
    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi=0;
        int si=0;
        while(gi<g.length && si<s.length){
            if(g[gi]<=s[si]){
                gi++;
                si++;
            }else{
                si++;
            }
        }

        return gi;

    }


    public static boolean isSubsequence(String s, String t) {
        boolean result=false;
        if(s.length()>1){
            char c1 = s.charAt(0);
            //所有出现的位置
            List<Integer> indexs = findIndexs(t, c1);
            for(int index:indexs){
                String subT = t.substring(index+1);
                String subS=  s.substring(1);
                boolean subsequence = isSubsequence(subS, subT);
                if(subsequence){
                    result=true;
                    break;
                }
            }

        }else if(s.length()==1){
            char c1 = s.charAt(0);
            if(findIndexs(t, c1).size()>0){
                result=true;
            }

        }else if(s.length()==0){
            result=true;
        }

        return result;
    }

    public static List<Integer> findIndexs(String s,char target){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==target){
                result.add(i);
            }
        }
        return  result;
    }


    public static int maxSubArray(int[] nums) {

        int[] sum=new int[nums.length];
        int result=Integer.MIN_VALUE;
        if(nums.length>0){
            sum[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                sum[i]=Math.max((sum[i-1]+nums[i]),nums[i]);
                if(sum[i]>result)
                    result=sum[i];
            }

        }


        return result;

    }


    class FreqWord{
        String word;
        int freq;
        FreqWord(String word,int freq){
            this.word=word;
            this.freq=freq;
        }
    }

    public  List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        Stack<String> stack=new Stack<>();
        Queue<FreqWord> queue=new PriorityQueue<>(k, new Comparator<FreqWord>() {
            @Override
            public int compare(FreqWord o1, FreqWord o2) {
                int result;
                if(o1.freq!=o2.freq){
                    result=(o1.freq-o2.freq);
                }else{
                  result=o2.word.compareTo(o1.word);
                }
                return result;
            }


        });

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> tmp:map.entrySet()){
            FreqWord freqWord=new FreqWord(tmp.getKey(),tmp.getValue());
            if(queue.size()<k){
                queue.add(freqWord);
            }else{
                if(freqWord.freq>queue.peek().freq){
                    queue.poll();
                    queue.add(freqWord);
                }else if(freqWord.freq==queue.peek().freq){
                    if(freqWord.word.compareTo(queue.peek().word)<0){
                        queue.poll();
                        queue.add(freqWord);
                    }
                }
            }
        }

        while(queue.size()>0){
            stack.push(queue.poll().word);
        }
        while(stack.size()>0){
            result.add(stack.pop());
        }



        return result;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] value=new int[days.length];

        for(int i=0;i<days.length;i++){
            if(i==0){
                value[i]=costs[0];
            }else{
                int day1 = findPreIndex(days, i, 1);
                int day7 = findPreIndex(days, i, 7);
                int day30 = findPreIndex(days, i, 30);
                int value1,value7,value30;
                if(day1==-1){
                    value1=costs[0];
                }else{
                    value1=value[day1]+costs[0];
                }
                if(day7==-1){
                    value7=costs[1];
                }else{
                    value7=value[day7]+costs[1];
                }
                if(day30==-1){
                    value30=costs[2];
                }else{
                    value30=value[day30]+costs[2];
                }

                int tmp=Math.min(value1,value7);
                value[i]=Math.min(value30,tmp);
            }

        }
        return  value[days.length-1];
    }

    public int findPreIndex(int[] days,int endIndex,int backDay){
        int index=endIndex;
        int startDay=days[index]-backDay+1;
        int i;

        Boolean find=false;
        for(i=index; i>=0;i--){
            int currentDay=days[i];
            if(currentDay<startDay){
                find=true;
                break;
            }
        }
        if(find)
            return i;
        else
            return -1;

    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result=new ArrayList<>();

        dfs(root,null);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> traveled=new HashSet<>();
        traveled.add(target);
        traveled.add(null);

        int distance=0;

        while(queue.size()>0){
            TreeNode poll = queue.poll();
            if(poll==null){

                if(distance==K){
                    break;
                }

                queue.add(null);
                distance++;

            }else {
                if(!traveled.contains(poll.left)){
                    traveled.add(poll.left);
                    queue.add(poll.left);
                }

                if(!traveled.contains(poll.right)){
                    traveled.add(poll.right);
                    queue.add(poll.right);
                }

                TreeNode pollParent = parents.get(poll);
                if(!traveled.contains(pollParent)){
                    traveled.add(pollParent);
                    queue.add(pollParent);
                }


            }
        }


        for(TreeNode t:queue){
            result.add(t.val);
        }

        return  result;


    }



    public void dfs(TreeNode node,TreeNode parent){
        if(node!=null){
            parents.put(node,parent);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }



    public int find(TreeNode root,TreeNode target){

        int result=-1;

        if(root!=null){
            if(root.val!=target.val){
                int left=-1,right=-1;

                left = find(root.left, target);
                right=find(root.right,target);

                if(left==-1 && right>0){
                    result=right+1;
                }else if(left>0 && right==-1){
                    result=left+1;
                }else {
                    result=-1;
                }

            }else if(root.val!=target.val){
                result=1;
            }

        }

        return result;

    }



    public int partition(int[] nums,int l,int h){

        int i=l,j=h+1;
        while(true){
            while(nums[++i]<nums[l] && i<h);
            while (nums[--j]>nums[l] && j>l);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,i,j);
        return j;
    }


    public void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }


    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }


    public boolean isValidParentheses(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.size()>0 && (c=='}' || c==')' || c==']')){
               if((c=='}' && stack.peek()=='{') || (c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='[')){
                   stack.pop();
                   continue;
               }else {
                   return false;
               }
            }else{
                stack.push(c);
            }
        }

        if(stack.size()>0)
            return false;
        else
            return true;


    }


    public int part(int[] nums,int l,int h){


        int j=l,t=h;
        int k=nums[l];
        while(true){

            while(j<h && nums[j+1]<k){
                j++;
            }
            while (t>l && nums[t]>k ){
                t--;
            }

            if(j>=t)
                break;
            swap(nums,j,t);

        }

        swap(nums,l,j);

        return j;
    }

    public void quickSort(int[] nums,int l,int h){

        if(l>=h)
            return;

        int j=part(nums,l,h);
        quickSort(nums,l,j-1);
        quickSort(nums,j+1,h);


    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }



    public void test(String[] nums){

        Arrays.sort(nums,(s1, s2) -> (s1 + s2).compareTo(s2 + s1));


    }



    static  class Person {
        private String age;
        private int money;

        Person(String age1,int money1){
            age=age1;
            money=money1;
        }
        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }
    public void mapreduce(List<Person> people){

        Map<String,Integer> result=new HashMap<>();
         people.stream().collect(Collectors.groupingBy(Person::getAge)).forEach(
                 (age,persons)->{
                    int sumMoney = persons.stream().map(person -> {
                         return person.getMoney();
                     }).reduce((a, b) -> (a + b)).get();
                    result.put(age,sumMoney);
                 }
         );

         System.out.println(result.size());


    }


    public int GetNumberOfK(int [] array , int k) {

        int small=0,big=0;
        int l=0,h=array.length;

        while(l<h){
            int mid=l+(h-l)/2;
            if(array[mid]>=k)
                h=mid;
            else if(array[mid]<k)
                l=mid+1;
        }
        small=l;
        System.out.println(small);
        /////////
        l=0;
        h=array.length;
        while(l<h){
            int mid=l+(h-l)/2;
            if(array[mid]>=(k+1))
                h=mid;
            else if(array[mid]<(k+1))
                l=mid+1;
        }
        big=l;
        System.out.println(big);
        if(small==array.length || array[small]!=k)
            return 0;

        return big-small;





    }

    int ret=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        startMax(root);
        return ret;
    }
    public int startMax(TreeNode root) {


        if(root==null)
            return 0;

            int left= Math.max(startMax(root.left),0);
            int right=Math.max(startMax(root.right),0);
            int max=Math.max(root.val+left,root.val+right);

            ret=Math.max(ret,root.val+left+right);

        return max;
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {

        int dis=0;
        Queue<String> queue=new LinkedList<>();
        queue.add(start);

        dict.remove(start);
        dict.add(end);

        while(queue.size()>0){

            dis++;
            int cnt=queue.size();
            while(cnt-- >0){
                String poll = queue.poll();
                List<String> delete=new ArrayList<>();
                if(distance(poll,end)==1) return dis;
                for(String dic:dict){
                    if(distance(poll,dic)==1){
                        queue.add(dic);
                        delete.add(dic);
                    }
                }

                for(String del:delete){
                    dict.remove(del);
                }
            }

        }
        return 0;
    }


    public int distance(String s1,String s2){

            int count=0;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i))
                    count++;
                if(count > 1){
                    break;
                }
            }

            return  count;
    }



    public boolean isPalindrome(String s) {

        s=s.toLowerCase();
        if(s==null || s.length()==0)
            return true;
        int start=0;
        int end=s.length()-1;

        while(start<end){
            if(isChar(s.charAt(start)) ){
                start++;
                continue;
            }
            if(isChar(s.charAt(end))){
                end--;
                continue;
            }

            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                break;
            }
        }

        if(start>=end)
            return true;
        else
            return false;
    }

    boolean isChar(char c){
       return ( c>='a' && c<='z') || Character.isDigit(c);
    }


    int index=1;
    public   int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] ret=new int[R*C][2];
        int distance=1;
        boolean[][] visited=new boolean[R][C];

        ret[0][0]=r0;
        ret[0][1]=c0;
        visited[r0][c0]=true;

        while(index<(R*C)){

            for(int i=0;i<=distance;i++){
                    int j=distance-i;
                    DFS(R,C,ret,visited,r0+i,c0+j);
                    DFS(R,C,ret,visited,r0-i,c0+j);
                    DFS(R,C,ret,visited,r0+i,c0-j);
                    DFS(R,C,ret,visited,r0-i,c0-j);
            }

            distance++;
        }

        return ret;

    }


     void DFS(int R, int C,int[][] ret,boolean[][] visited,int r,int c){
            if(r<R && r>=0 && c<C && c>=0 && !visited[r][c]){
                visited[r][c]=true;
                ret[index][0]=r;
                ret[index][1]=c;
                index++;
            }
    }

    public static void main(String[] args) {



       new Solution().allCellsDistOrder(2,3,1,2);






    }
}
