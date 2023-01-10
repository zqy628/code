package com.code.day;

import java.util.Arrays;

public class ReinitializePermutation_1806 {
    public int reinitializePermutation(int n) {
        int res = 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                arr[i] = i/2;
            } else {
                arr[i] = n/2 + (i-1)/2;
            }
        }
        while (arr[1] != 1) {
            arr = swap(arr, n);
            res++;
        }
        return res;
    }

    private static int[] swap(int[] arr, int n) {
        int[] perm = arr.clone();
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                perm[i] = arr[i/2];
            } else {
                perm[i] = arr[n/2 + (i-1)/2];
            }
        }
        arr = perm;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        arr = swap(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

}