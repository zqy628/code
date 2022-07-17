package com.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zqy on 2022/6/30.
 */
public class FindMinArrowShots_452 {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int r = points[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > r) {
                r = points[i][1];
                count++;
            }
        }
        return count;
    }
}
