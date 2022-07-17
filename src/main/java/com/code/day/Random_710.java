package com.code.day;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @author zqy on 2022/6/27.
 */
public class Random_710 {
    int n_, m, idx;
    Random random = new Random();
    HashMap<Integer, Integer> map = new HashMap<>();
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();

    public Random_710(int n, int[] blacklist) {
        n_ = n;
        m = n - blacklist.length;
        for (int b : blacklist) {
            if (b < m) {
                s1.add(b);
            } else {
                s2.add(b);
            }
        }
        idx = m;
    }

    public int pick() {
        int nextInt = random.nextInt(m);
        if (!s1.contains(nextInt)) {
            return nextInt;
        }
        if (!map.containsKey(nextInt)) {
            while (s2.contains(idx)) {
                idx++;
            }
            map.put(nextInt, idx++);
        }
        return map.get(nextInt);
    }
}
