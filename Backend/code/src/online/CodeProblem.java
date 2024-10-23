package online;


import org.apache.ecs.html.S;

import java.util.*;

public class CodeProblem {




     List<String> ret = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,new ArrayList<>());
        return ret;
    }

    void backTrack(String s,int start, List<String> list){
        if(start>s.length()){
            return;
        }

        if(start==s.length() && list.size()==4){
            StringBuilder sb = new StringBuilder();
            for (String ss : list) {
                sb.append(ss).append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            ret.add(sb.toString());
            return;
        }

        for(int i=1;i<=3;i++){
            if(start+i>s.length()) {
                continue;
            }
            String ip = s.substring(start, start + i);
            if(validIp(ip)){
                list.add(ip);
                backTrack(s,start + i,list);
                list.remove(list.size()-1);
            }
        }
    }

    boolean validIp(String ipStr){
        if("0".equals(ipStr)) {
            return true;
        }
        if(ipStr.startsWith("0")){
            return  false;
        }
        int ipNum = Integer.parseInt(ipStr);
        if(ipNum>255){
            return false;
        }
        return true;
    }




    public static void main(String[] args) {
       System.out.println(new CodeProblem().restoreIpAddresses("25525511135"));
       System.out.println(new CodeProblem().restoreIpAddresses("0000"));
       System.out.println(new CodeProblem().restoreIpAddresses("101023"));

    }
}
