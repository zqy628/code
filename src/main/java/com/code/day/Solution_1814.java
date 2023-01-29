package com.code.day;
//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ，
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution_1814 {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int r = num - rev(num);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        long res = 0;
        for (Integer cha : map.keySet()) {
            Integer integer = map.get(cha);
            if (integer>=2) {
                res += (long)integer * (long)(integer-1) / 2;
            }
        }
        return (int)(res % MOD);
    }
    private int rev(int num) {
        int r = 0;
        while (num !=0) {
            r = 10 * r + num % 10;
            num = num / 10;
        }
        return r;
    }

    // 官方解法
    class Solution {
        public int countNicePairs(int[] nums) {
            final int MOD = 1000000007;
            int res = 0;
            Map<Integer, Integer> h = new HashMap<Integer, Integer>();
            for (int i : nums) {
                int temp = i, j = 0;
                while (temp > 0) {
                    j = j * 10 + temp % 10;
                    temp /= 10;
                }
                // 每一个索引位置单独计算与前面位置可以形成的数对
                res = (res + h.getOrDefault(i - j, 0)) % MOD;
                h.put(i - j, h.getOrDefault(i - j, 0) + 1);
            }
            return res;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
