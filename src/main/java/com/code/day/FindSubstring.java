package com.code.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zqy on 2022/6/24.
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int count = words.length;//单词个数
        int size = words[0].length();//单词统一长度
        // 频次map
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - count * size + 1; i++) {
            String substring = s.substring(i, i + count * size);
            // System.out.println(substring);
            boolean b = check(substring, map, size);
            if (b) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean check(String substring, HashMap<String, Integer> map, int size) {
        HashMap<String, Integer> clone = (HashMap<String, Integer>) map.clone();
        for (int i = 0; i < substring.length(); i= i+size) {
            String s = substring.substring(i, i +  size);
            // System.out.println(s);
            if (!clone.containsKey(s)) {
                return false;
            } else {
                clone.put(s, clone.get(s) - 1);
                if (clone.get(s) == 0) {
                    clone.remove(s);
                }
            }
        }
        return clone.isEmpty();
    }
}
