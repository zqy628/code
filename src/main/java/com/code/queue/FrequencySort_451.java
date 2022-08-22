package com.code.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zqy on 2022/7/17.
 */
public class FrequencySort_451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : entries) {
            priorityQueue.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }

}
