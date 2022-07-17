package com.code.day;

import java.util.Arrays;

/**
 * @author zqy on 2022/6/27.
 */
public class Fenshuafangzi_091 {
    public int minCost(int[][] costs) {
        int fangzi = costs.length;
        int[] minCost = new int[3];
        for (int i = 0; i < fangzi; i++) {
            int[] clone = minCost.clone();

            minCost[0] = Math.min(clone[1], clone[2]) + costs[i][0];
            minCost[1] = Math.min(clone[0], clone[2]) + costs[i][1];
            minCost[2] = Math.min(clone[1], clone[0]) + costs[i][2];
        }
        return Arrays.stream(minCost).min().getAsInt();
    }


}
