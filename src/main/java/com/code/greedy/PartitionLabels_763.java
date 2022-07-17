package com.code.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zqy on 2022/6/30.
 */
public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = map.get(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

}
