package com.code.greedy;

/**
 * @author zqy on 2022/7/1.
 */
public class CheckPossibility_665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length==1) return true;
        int bk = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                bk = i;
                break;
            }
        }
        if (bk == -1) {
            return true;
        }
        int num = nums[bk];
        nums[bk] = nums[bk-1];
        boolean r1 = check(nums);
        nums[bk] = num;
        nums[bk-1] = nums[bk];
        boolean r2 = check(nums);
        return r1 || r2;
    }

    private boolean check(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
