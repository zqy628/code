package com.code.day;

public class Solution_1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int[] point : points) {
            for (int i = 0; i < queries.length; i++) {
                if (Math.pow(Math.abs(point[0]-queries[i][0]),2) + Math.pow(Math.abs(point[1]-queries[i][1]),2) <= Math.pow(queries[i][2],2)) {
                    res[i] ++;
                }
            }
        }
        return res;
    }
}