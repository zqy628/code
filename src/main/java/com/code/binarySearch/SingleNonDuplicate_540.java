package com.code.binarySearch;

/**
 * @author zqy on 2022/7/17.
 */
public class SingleNonDuplicate_540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l<r) {
            int mid = (l+r) / 2;
            //偶数位
            /**
             * 细节
             *
             * 利用按位异或的性质，可以得到 mid 和相邻的数之间的如下关系，其中 ⊕ 是按位异或运算符：
             *
             * 当 mid 是偶数时，mid+1=mid⊕1；
             * 当 mid 是奇数时，mid−1=mid⊕1。
             * 因此在二分查找的过程中，不需要判断 mid 的奇偶性，mid 和 mid⊕1 即为每次需要比较元素的两个下标。
             * if (nums[mid] == nums[mid ^ 1]) { low = mid + 1; } else { high = mid; }
             */
            if (mid >> 1 == 0) {
                // 在左边
                if (nums[mid] != nums[mid+1]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            } else {
                // 在左边
                if (nums[mid] == nums[mid+1]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            }
        }
        return nums[l];
    }

}
