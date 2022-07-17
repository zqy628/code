package com.code.slidewindow;

/**
 * @author zqy on 2022/7/16.
 */
public class FindMin_154 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int l=0;
        int r=length-1;
        int mid = (l+r) / 2;
        while (l<r) {
            //左边有序,在右边寻找
            if (nums[r] < nums[mid] ) {
                l = mid +1;
            } else if (nums[r] > nums[mid]){
                //左边查找,mid位置可能是正确的值
                r = mid;
            } else{
                // 不确定哪边有序,r--
                r--;
            }
            mid = (l+r) / 2;
        }
        return nums[mid];
    }

}
