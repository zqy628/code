package com.code.dp;

/**
 * @author zqy on 2022/8/25.
 */
//给定两个单词 word1 和
// word2 ，返回使得
// word1 和
// word2 相同所需的最小步数。
//
// 每步 可以删除任意一个字符串中的一个字符。
//
//
//
// 示例 1：
//
//
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
//
//
// 示例 2:
//
//
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
//
//
//
//
// 提示：
//
//
//
// 1 <= word1.length, word2.length <= 500
// word1 和 word2 只包含小写英文字母
//
//
// Related Topics 字符串 动态规划 👍 482 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class MinDistance_583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // if (word1.charAt(0) != word2.charAt(0)) {
        //     dp[1][1] = 1;
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // [i][j] 相等 = [i-1][j-1]
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i+1][j] + 1, dp[i][j+1] + 1);

                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

