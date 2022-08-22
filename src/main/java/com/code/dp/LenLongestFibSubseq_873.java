package com.code.dp;

import java.util.HashMap;

/**
 * @author zqy on 2022/7/21.
 */
public class LenLongestFibSubseq_873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // 值和索引的映射
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int res=0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]*2<=arr[i]) {
                    dp[i][j] = 2;
                    continue;
                }
                int k = arr[i] - arr[j];
                if (map.containsKey(k)) {
                    // 初始值为2
                    if (dp[j][map.get(k)] == 0) {
                        dp[j][map.get(k)] = 2;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[j][map.get(k)]+1);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

}
