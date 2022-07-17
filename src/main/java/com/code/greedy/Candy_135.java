package com.code.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zqy on 2022/6/21.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                r[i] = r[i - 1] + 1;
            }
        }
        for (int j = n-2; j >=0; j--) {
            if (ratings[j] > ratings[j + 1] && r[j] <= r[j + 1]) {
                r[j] = r[j + 1] + 1;
            }
        }
        return Arrays.stream(r).sum()+n;
    }
}
