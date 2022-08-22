package com.code.search;

/**
 * @author zqy on 2022/7/19.
 */
public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, visit, i, j);
                    res = Math.max(res, size);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visit[i][j] == 1) {
            return 0;
        } else {
            visit[i][j] = 1;
            return 1 + dfs(grid, visit, i-1, j) + dfs(grid, visit, i+1, j) + dfs(grid, visit, i, j-1) + dfs(grid, visit, i, j+1);
        }
    }
}
