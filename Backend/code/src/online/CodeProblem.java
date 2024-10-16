package online;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CodeProblem {

    public  String merge(String s1, String s2) {
        // write code here

        String[] list1=s1.split(",");
        String[] list2 = s2.split(",");

        int l1=0;
        int l2=0;
        StringBuilder sb = new StringBuilder();
        while(l1<list1.length || l2<list2.length){
            if(l1>=list1.length && l2<list2.length ){
                sb.append(list2[l2]).append(",");
                l2++;
            }else if(l1<list1.length && l2>=list2.length){
                sb.append(list1[l1]).append(",");
                l1++;
            }else if(l1<list1.length && l2<list2.length){
                if(Integer.parseInt(list1[l1])<=Integer.parseInt(list2[l2])){
                    sb.append( list1[l1]).append(",");
                    l1++;
                }else {
                    sb.append(list2[l2]).append(",");
                    l2++;
                }
            }

        }

       sb.deleteCharAt(sb.length()-1);

        return sb.toString();

    }


    // "1 7 3 45 3 8",3  => 45 8 7 3 3 1==> 7
    public static int find(String s1, int k) {
        // write code here
        if(s1==null || s1.length()==0){
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        String[] list = s1.split(" ");

        for (String s : list) {
            int num = Integer.parseInt(s);
            if(minHeap.isEmpty() || minHeap.size()<k){
                minHeap.add(num);
            }else {
                Integer peek = minHeap.peek();
                if(num>peek){
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        int[] ints =

    }
}
