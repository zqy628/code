package com.code.dp;
//给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
//
// 比方说，如果 nums = [6,1,7,4,1] ，那么： 
//
// 
// 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。 
// 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。 
// 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。 
// 
//
// 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。 
//
// 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,6,4]
//输出：1
//解释：
//删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
//删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
//删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
//删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
//只有一种让剩余数组成为平衡数组的方案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：3
//解释：你可以删除任意元素，剩余数组都是平衡数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：0
//解释：不管删除哪个元素，剩下数组都不是平衡数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution_1664 {
    public int waysToMakeFair(int[] nums) {
        // 右侧奇偶数和
        int odd = 0;
        int even = 0;
        int res = 0;
        //预处理
        for (int i = 0; i < nums.length; i++) {
            if ((i&1)==0) {
                odd += nums[i];
            } else {
                even += nums[i];
            }
        }
        // 左侧奇偶数和
        int odd_ = 0;
        int even_ = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果为奇数位置
            if ((i&1)==0) {
                // 右侧奇数和减去此数
                odd -= nums[i];
                // 左侧奇数和和右侧偶数和相加 是否等于 左侧偶数和和右侧奇数和相加(删去一个数右侧奇偶位置会变化)
                if (odd_ + even == odd + even_) {
                    res++;
                }
                // 计算完毕左侧奇数和加上此数
                odd_ += nums[i];
            } else {
                even -= nums[i];
                if (odd_ + even == odd + even_) {
                    res++;
                }
                even_ += nums[i];
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
