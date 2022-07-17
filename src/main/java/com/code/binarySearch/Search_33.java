package com.code.binarySearch;

/**
 * @author zqy on 2022/7/13.
 */
public class Search_33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            //5 6 7 8 1 左半部分有序,永远根据第一个元素判断
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // 5 1 2 3 4 有半部分有序
            else {
                if (nums[length - 1] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l+" "+r);
            // mid = (l+r)/2;
        }

        return -1;
    }

}
