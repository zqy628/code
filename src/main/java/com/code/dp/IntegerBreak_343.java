package com.code.dp;

/**
 * @author zqy on 2022/8/25.
 */
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
// 返回 你可以获得的最大乘积 。
//
//
//
// 示例 1:
//
//
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
//
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
//
//
// 提示:
//
//
// 2 <= n <= 58
//
//
// Related Topics 数学 动态规划 👍 913 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class IntegerBreak_343 {
    public int integerBreak(int n) {
        // i 2-n  i = max(dp[1]*i-1,dp[2]*i-2)
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int mid = i >> 1;
            for (int j = 1; j <= mid; j++) {
                dp[i] = Math.max(dp[i-j] * dp[j], dp[i]);
                if (i!=n) {
                    dp[i] = Math.max(dp[i],i);
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
