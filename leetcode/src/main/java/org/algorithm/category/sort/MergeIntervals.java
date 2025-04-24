package org.algorithm.category.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] peek=list.get(list.size()-1);
            if(intervals[i][0]> peek[1]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }else if(intervals[i][1]<peek[0]){
                continue;
            }else {
                int[] newInterval = new int[]{Math.min(peek[0],intervals[i][0]),Math.max(peek[1],intervals[i][1])};
                list.set(list.size()-1,newInterval);
            }
        }

        int[][] ret = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }

        return ret;
    }
}
