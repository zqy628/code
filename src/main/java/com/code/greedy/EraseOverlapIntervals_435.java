package com.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zqy on 2022/6/30.
 */
public class EraseOverlapIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int r = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= r) {
                r = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
