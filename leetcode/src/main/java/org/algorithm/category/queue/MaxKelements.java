package org.algorithm.category.queue;

import java.util.PriorityQueue;

/**
 * 2530
 */
public class MaxKelements {

    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k, (a, b) -> b.compareTo(a));

        for (int num : nums) {
            maxQueue.add(num);
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (maxQueue.isEmpty()) {
                break;
            }
            Integer peekVal = maxQueue.poll();
            sum += peekVal;
            if (peekVal % 3 == 0) {
                maxQueue.add(peekVal / 3);
            } else {
                maxQueue.add(peekVal / 3 + 1);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int k=2;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k,(a,b)->b.compareTo(a));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        int[] nums= new int[]{1,2,3,4,5};
        for ( int num : nums) {
            if(minQueue.size()<k){
                minQueue.add(num);
                maxQueue.add(num);
            }else{
                if(num>minQueue.peek()){
                    minQueue.add(num);
                    maxQueue.add(num);
                }
            }
        }


//        System.out.println(new MaxKelements().maxKelements(new int[]{10,10,10,10,10},5));
//        System.out.println(new MaxKelements().maxKelements(new int[]{1,10,3,3,3},3));

    }
}
