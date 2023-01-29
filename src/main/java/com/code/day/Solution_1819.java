package com.code.day;

import java.util.Arrays;

public class Solution_1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        /**
        *
        * 巧妙枚举
        * 根据最大公约数的性质，如果最大公约数为i的子序列加上某一个i的倍数的值，最大公约数i不变
        * 那么我们可以从最小的数开始假设，枚举出所有可能的最大公约数
        * 在枚举过程中，构造子序列，当存在构造的数是nums里面的值，才计算最大公约数
        * 最后计算出来的公约数和假设的对比
        * 如果相同，则答案+1
        *
        */
        int ans = 0 , max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        //用哈希表记录是否存在nums中的值，长度为max+1是因为假设nums是从1...max的序列，那么最大长度为max（不可能比max大），且要记录exist[max]=true，所以长度要+1
        boolean[] exist = new boolean[max+1];
        for(int num : nums){
            exist[num] = true;
        } 
        //从1开始枚举最大公约数
        for(int i = 1 ; i <= max;i++){
            //任何数跟0的最大公约数都是其本身
            int g = 0;
            //构造子序列
            for(int j = i ; j <= max && g != i;j+=i){
                //当j存在在nums中，计算最大公约数
                if(exist[j]){
                    g = gcd(g,j);
                }
                //对比假设和计算出来的最大公约数，一致则答案加1
                if(g==i){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}

// 官方题解
class Solution_ {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occured = new boolean[maxVal + 1];
        for (int num : nums) {
            occured[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for (int j = i; j <= maxVal; j += i) {
                if (occured[j]) {
                    if (subGcd == 0) {
                        subGcd = j;
                    } else {
                        subGcd = gcd(subGcd, j);
                    }
                    if (subGcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}