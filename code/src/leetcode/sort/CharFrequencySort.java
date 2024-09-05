package leetcode.sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TODO
public class CharFrequencySort {

    // proble 451
    public static String frequencySort(String s) {
        HashMap<String, Integer> bucket = new HashMap<String, Integer>();

        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            if (bucket.containsKey(tmp)) {
                bucket.put(tmp, bucket.get(tmp) + 1);
            } else {
                bucket.put(tmp, 1);
            }
        }

        List<Map.Entry<String, Integer>> listMap = bucket.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());


        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> e : listMap) {
            int freq = e.getValue();
            String ss = e.getKey();
            for (int k = 0; k < freq; k++)
                //result=result+""+ss;
                result.append(ss);
        }


        return result.toString();
    }
}
