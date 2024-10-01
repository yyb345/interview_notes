package org.algorithm;

public class Calculataion {

//    public int calculate(String s) {
//
//        String trim = s.trim();
//
//        List<String> dataList = new ArrayList<>();
//        List<Character> opList = new ArrayList<>();
//        int pre=0;
//        for(int i=0;i<trim.length();i++){
//            char c = trim.charAt(i);
//            if(c=='*' || c=='/' || c=='+' || c=='-' ){
//                dataList.add(trim.substring(pre,i));
//                opList.add(c);
//                pre=i+1;
//            }
//        }
//        dataList.add(trim.substring(pre));
//
//
//
//    }

    public static int mySqrt(int x) {


        long l = 0;
        long h = x;
        long r = l;
        while(l<h){
            long mid = l + (h-l)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid<x){
                r = mid;
                l = mid+1;
            }else {
                h = mid-1;
            }
        }

        return (int) r;
    }

    public static void main(String[] args) {


        System.out.println(mySqrt(2147395599));
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
    }

}
