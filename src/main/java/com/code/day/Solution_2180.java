package com.code.day;
//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
//
// 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4
//输出：2
//解释：
//只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。    
// 
//
// 示例 2： 
//
// 
//输入：num = 30
//输出：14
//解释：
//只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是： 
//2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 1000 
// 
//
// Related Topics 数学 模拟


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution_2180 {
    public int countEven(int num) {
        int res=0;
        for (int i = 1; i <= num; i++) {
            if (checkEven(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean checkEven(int i) {
        int sum = 0;
        while (i!=0) {
            sum += i&1;
            i /= 10;
        }
        return (sum & 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
