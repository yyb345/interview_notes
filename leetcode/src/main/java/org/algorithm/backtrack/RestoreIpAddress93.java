package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 */
public class RestoreIpAddress93 {

    List<String> ret = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,new ArrayList<>());
        return ret;
    }

    void backTrack(String s,int start, List<String> list){
        if(start>s.length() || list.size()>4){
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

        for(int i=1;i<=3 && start+i<=s.length() ;i++){
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
}
