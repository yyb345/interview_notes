package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {

    PriorityQueue<KRecord> priorityQueue;
    Map<Integer,KRecord> map;

    public LRUCache(int capacity) {
        priorityQueue = new PriorityQueue<>(capacity,(k1,k2)->{
            if(k1.timeStamp>k2.timeStamp){
                return -1;
            }else if(k1.timeStamp<k2.timeStamp){
                return 1;
            }else {
                return k1.visitNum-k2.visitNum;
            }

        });



        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        // 更新最大堆
        KRecord krecord = map.get(key);
        priorityQueue.remove(krecord);
        krecord.setTimeStamp(System.currentTimeMillis());
        krecord.setVisitNum(krecord.getVisitNum()+1);
        priorityQueue.add(krecord);

        if(krecord!=null){
            return krecord.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        KRecord kRecord = new KRecord();
        kRecord.setTimeStamp(System.currentTimeMillis());
        kRecord.setValue(value);
        kRecord.setVisitNum(1);
        map.put(key,kRecord);
        priorityQueue.add(kRecord);
    }

    static class KRecord{
        int value;
        long timeStamp;
        int visitNum;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public int getVisitNum() {
            return visitNum;
        }

        public void setVisitNum(int visitNum) {
            this.visitNum = visitNum;
        }
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0){
            return false;
        }
        return dfs(s,wordDict);
    }

    boolean dfs(String word, List<String> wordDict){
        if(word==null || word.length()==0){
            return true;
        }
        for(String dic:wordDict){
            if(word.startsWith(dic)){
                String subword=word.substring(word.length());
                if(dfs(subword,wordDict)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
//        LRUCache lruCache = new LRUCache(4);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.put(3,3);
//        lruCache.put(4,4);
//        lruCache.put(5,5);
//
//        //int i = lruCache.get(5);
//        System.out.println(lruCache.get(5));

        //new LRUCache(10).wordBreak("catsandog",);
    }
}
