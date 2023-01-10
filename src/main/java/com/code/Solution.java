package com.code;

import java.util.Arrays;

/**
 * @author zqy on 2022/8/24.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,2,4,6,8};
        System.out.println(bs(arr, 5));
        System.out.println(Arrays.binarySearch(arr, 5));
    }
    private static int bs(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;
        int mid = (l+r) >> 1;
        while (l<=r) {
            if (x==arr[mid]) {
                return mid;
            }
            if (arr[mid] > x) {
                r = mid-1;
            } else {
                l = mid +1;
            }
            mid = (l+r) >> 1;
        }
        System.out.println("" + l+mid+r);
        return l;
    }

}
