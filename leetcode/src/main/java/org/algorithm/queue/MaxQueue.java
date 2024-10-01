package org.algorithm.queue;

import java.util.ArrayList;
import java.util.List;

class MaxQueue {

    List<Integer> arrayList;
    List<Integer> maxList;
    public MaxQueue() {
        arrayList= new ArrayList<>();
        maxList = new ArrayList<>();
    }

    public int max_value() {
        if(maxList.isEmpty()){
            return -1;
        }
        return maxList.get(maxList.size()-1);
    }

    public void push_back(int value) {
        arrayList.add(value);
        maxList.add(Math.max(value,max_value()));
    }

    public int pop_front() {
        if(arrayList.isEmpty()){
            return -1;
        }
        maxList.remove(0);
        return  arrayList.remove(0);
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.add(4);
        System.out.println(list.toString()
        );
    }
}
