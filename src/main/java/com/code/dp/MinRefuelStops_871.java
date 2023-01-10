package com.code.dp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * dp
 * @author zqy on 2022/7/4.
 */
public class MinRefuelStops_871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        if (stations.length==0) {
            return -1;
        }
        int length = stations.length;
        int[] dp = new int[length+1];
        dp[0] = startFuel;
        for (int i = 0; i < length; i++) {
            // 注意得从后往前遍历,不然本次循环会影响初始数据
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j+1] = Math.max(dp[j] + stations[i][1], dp[j+1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法2
     * 总结下评论区的思路，这个题目要这样想：
     *
     * 路上的不是加油站，而是一桶桶的油，每次经过的时候，就把油带上，当油不够的时候我们就取身上最大的那桶油加上，这样如果身上没油了，那么就到不了了
     */
    public int minRefuelStops_2(int target, int startFuel, int[][] stations) {
        int fuel = startFuel, dist = 0, times = 0, i = 0, len = stations.length;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (; ; ) {
            dist += fuel;// 直接清空油箱，冲到底
            if (dist >= target) return times;// 到终点了
            while (i < len && stations[i][0] <= dist) {// 把路过的加油包收集起来
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) return -1;// 没加油包了
            fuel = queue.poll();// 取最大的一个加油包加上
            ++times;
        }
    }
}
