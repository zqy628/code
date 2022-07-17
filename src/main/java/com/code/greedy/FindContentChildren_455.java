package com.code.greedy;

import java.util.Arrays;

/**
 * @author zqy on 2022/6/21.
 */
public class FindContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = 0, b = 0;
        while (a < g.length && b < s.length) {
            if (g[a] <= s[b]) {
                a++;
            }
            b++;
        }
        return a;
    }
}
