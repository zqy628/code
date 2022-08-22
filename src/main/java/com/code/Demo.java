package com.code;

import com.code.day.FindBottomLeftValue_513;

import javax.sound.midi.MidiChannel;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author zqy on 2022/7/17.
 */
public class Demo {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
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
                if (nums[mid] != nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                // 在左边
                if (nums[mid] == nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    private static void quickSort(int[] nums, int left, int right) {
        int num = nums[left];
        int i = left;
        int j = right - 1;
        while (i < j) {
            while (i < j && nums[j] >= num) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < num) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = num;
        if (i > left) {
            quickSort(nums, left, i);
        }
        if (i + 1 < right) {
            quickSort(nums, i + 1, right);
        }
    }

    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k, 0, nums.length);
        return nums[k];
    }

    private void quickSort(int[] nums, int k, int left, int right) {
        int num = nums[left];
        int i = left;
        int j = right - 1;
        while (i < j) {
            while (i < j && nums[j] >= num) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < num) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = num;
        if (i == k) return;
        if (i > left) {
            quickSort(nums, left, i);
        }
        if (i + 1 < right) {
            quickSort(nums, i + 1, right);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (priorityQueue.size() <= k) {
                priorityQueue.offer(entry);
            } else {
                if (entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : entries) {
            priorityQueue.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }


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

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] a = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i*n+j] = grid[i][j];
            }
        }
        k = k % (m*n);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                l.add(a[(m*n-k+i*n+j)%(m*n)]);
            }
            res.add(l);
        }
        return res;
    }

    public int lenLongestFibSubseq(int[] arr) {
        return 0;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visit = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]==0) {
                dfss(isConnected, visit, i);
                res++;
            }
        }
        return res;
    }

    private void dfss(int[][] isConnected, int[] visit, int i) {
        if (visit[i]==1) {
            return;
        }
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j]==1 && visit[j]==0) {
                dfss(isConnected, visit, j);
                visit[j]=1;
            }
        }
    }

    public int intersectionSizeTwo(int[][] intervals) {
        // 左区间从小到大,右区间从大到小
        Arrays.sort(intervals, (o1, o2) -> o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0]);
        int res = 2;
        int n = intervals.length;
        int l = intervals[n-1][0];
        // 贪心的只取区间前两位数
        int r = intervals[n-1][0] + 1;
        for (int i = n-2; i >= 0; i--) {
            if (intervals[i][1] >= r) {

            } else if (intervals[i][1] < l) {
                l = intervals[i][0];
                r = intervals[i][0] + 1;
                res = res + 2;
            } else {
                res++;
                r = l;
                l = intervals[i][0];
            }
        }
        return res;
    }

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int res = root.val;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                res += poll.val;
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);

                }
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
