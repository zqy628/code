package com.code.search;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zqy on 2022/7/20.
 */
public class FindCircleNum_547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visit = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]==0) {
                dfss(isConnected, visit, i);
                res++;
            }
        }
        return res;
    }

    private void dfss(int[][] isConnected, int[] visit, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j]==1 && visit[j]==0) {
                visit[j]=1;
                dfss(isConnected, visit, j);
            }
        }
    }

    // 广度优先
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        int[] visit = new int[n];
        int res = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    visit[poll] = 1;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[poll][j] == 1 && visit[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

}
