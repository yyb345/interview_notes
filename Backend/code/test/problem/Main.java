package problem;

import java.util.*;

public class Main {


    public int[] arrayRankTransform(int[] arr) {

        if(arr==null || arr.length==0){
            return new int[]{};
        }

        int[] rankList = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        int rank=1;
        map.put(arr[0],1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                rank++;
                map.put(arr[i],rank);
            }
        }
        for(int i=0;i<newArr.length;i++){
            rankList[i]=map.get(newArr[i]);
        }

        return rankList;
    }

    public static void main(String[] args) {

//       Stack<Integer> stack = new Stack<>();
//       stack.push(1);
//       stack.push(2);
//       System.out.println(stack.elementAt(0));
//        System.out.println(stack.elementAt(1));

        List<Integer> list = new ArrayList<>();

        String xx = "sabc";
        xx.indexOf("a");

    }
}
