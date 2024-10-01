package org.algorithm.queue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

//TODO
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        if( num==null || num.length<size)
            return null;

        ArrayList<Integer> ret=new ArrayList<>();

        Queue<Integer> heap=new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int i=0;i<size;i++)
            heap.add(num[i]);
        ret.add(heap.peek());


        int i=0,j=i+size;
        while(j<num.length){
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
            i++;
            j++;
        }

        return ret;


    }
}
