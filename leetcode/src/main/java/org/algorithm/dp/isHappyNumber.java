package org.algorithm.dp;

import java.util.HashSet;
import java.util.Set;


//TODO
public class isHappyNumber {

    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {

        if(set.contains(n)){
            return false;
        }

        String ns = String.valueOf(n);
        int sum = 0;

        for(int i=0;i<ns.length();i++){
            int cInt =  Integer.parseInt(ns.substring(i, i+1));
            sum+= (cInt*cInt);
        }
        if(sum==1){
            return true;
        }
        boolean sumHappy = isHappy(sum);
        if(!sumHappy){
            set.add(sum);
        }
        return sumHappy;
    }
}
