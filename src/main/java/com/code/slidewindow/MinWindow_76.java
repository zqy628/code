package com.code.slidewindow;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zqy on 2022/7/8.
 */
public class MinWindow_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l=0,r=0;
        // 双指针左移
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = r = i;
                break;
            }
        }
        int len = s.length();
        String result = "";
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                // l右移
                while (l < r && (map.containsKey(s.charAt(l)) && map.get(s.charAt(l)) < 0) || !map.containsKey(s.charAt(l))) {
                    // System.out.println(l + " " + r);
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    }
                    l++;
                }
                // map元素<=0
                if(checkMap(map)) {
                    if (len >= r - l + 1) {
                        len = r - l + 1;
                        result = s.substring(l, r + 1);
                        // System.out.println(result);
                    }
                }
            }
            r++;
        }
        return result;
    }

    private boolean checkMap(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
