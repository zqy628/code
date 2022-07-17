package com.code.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zqy on 2022/7/17.
 */
public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            // System.out.println(priorityQueue);
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            } else {
                if (entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
        }
        // System.out.println(priorityQueue);

        int[] res = new int[k];
        for (int i = 0; i <k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }

}
