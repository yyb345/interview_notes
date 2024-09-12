package leetcode;

import java.util.Arrays;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");

        return compare(list1,list2,0);
    }

    int compare(String[] list1,String[] list2,int index){
        if(index>=list1.length && index>=list2.length){
            return 0;
        }
        int num1= index>=list1.length?0:Integer.parseInt(list1[index]);
        int num2= index>=list2.length?0:Integer.parseInt(list2[index]);

        if(num1<num2){
            return -1;
        }else if(num1<num2){
            return 1;
        }else {
            return compare(list1,list2,index+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("1.2","1.10"));
        System.out.println(new CompareVersion().compareVersion("1.01","1.001"));
        System.out.println(new CompareVersion().compareVersion("1.0","1.0.0.0"));
    }
}
