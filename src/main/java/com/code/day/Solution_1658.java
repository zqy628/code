package com.code.day;//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 👍 258 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution_1658 {
    // 自解
    public int minOperations(int[] nums, int x) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        // int[] prefix = nums.clone();
        // int[] suffix = nums.clone();
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > x) {
                break;
            }
            map.put(x - sum, i + 1);
        }
        if (map.containsKey(0)) {
            res = map.get(0);
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > x) {
                break;
            }
            if (sum == x) {
                res = Math.min(res, n - i);
            }
            if (map.containsKey(sum)) {
                if (map.get(sum) - i < 0) {
                    res = Math.min(res, map.get(sum) + n - i);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param x
     * @return
     */
    public int minOperations_(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }

        return ans > n ? -1 : ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
