package com.code.greedy;

import java.util.Arrays;

/**
 * @author zqy on 2022/7/22.
 */
public class IntersectionSizeTwo_757 {
    public int intersectionSizeTwo(int[][] intervals) {
        // 左区间从小到大,右区间从大到小
        Arrays.sort(intervals, (o1, o2) -> o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0]);
        int res = 2;
        int n = intervals.length;
        int l = intervals[n-1][0];
        // 贪心的只取区间前两位数
        int r = intervals[n-1][0] + 1;
        for (int i = n-2; i >= 0; i--) {
            if (intervals[i][1] >= r) {

            } else if (intervals[i][1] < l) {
                l = intervals[i][0];
                r = intervals[i][0] + 1;
                res = res + 2;
            } else {
                res++;
                r = l;
                l = intervals[i][0];
            }
        }
        return res;
    }

}
