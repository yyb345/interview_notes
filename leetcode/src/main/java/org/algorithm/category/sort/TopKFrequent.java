package org.algorithm.category.sort;

import java.util.*;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 0);
            }
        }
        //构建最小堆
        PriorityQueue<Integer> queue = new PriorityQueue((n1, n2) -> hashMap.get(n1) - hashMap.get(n2));

        for (Map.Entry<Integer, Integer> keys : hashMap.entrySet()) {
            queue.add(keys.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
            // 输出最终形式
            while (queue.size() > 0) {
                result.add(queue.poll());
            }
            Collections.reverse(result);

            return result;
        }


        return result;
    }
}
