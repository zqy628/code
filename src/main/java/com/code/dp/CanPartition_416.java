package com.code.dp;

/**
 * @author zqy on 2022/8/22.
 */
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 1458 👎 0


import java.util.Arrays;

public class CanPartition_416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int s = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[s + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = s; j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]] | dp[j];
            }
        }
        return dp[s];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

