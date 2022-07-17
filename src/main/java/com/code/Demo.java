package com.code;

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
        while (l<r) {
            int mid = (l+r) / 2;
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
                if (nums[mid] != nums[mid+1]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            } else {
                // 在左边
                if (nums[mid] == nums[mid+1]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            }
        }
        return nums[l];
    }


    private static void quickSort(int[] nums,int left,int right) {
        int num = nums[left];
        int i = left;
        int j = right-1;
        while (i<j) {
            while (i<j && nums[j] >= num) {
                j--;
            }
            nums[i] = nums[j];
            while (i<j && nums[i] < num) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = num;
        if (i > left) {
            quickSort(nums, left, i);
        }
        if (i+1<right) {
            quickSort(nums, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] m = {3,2,8,4,9,0};
        quickSort(m, 0, m.length);
        for (int i : m) {
            System.out.println(i);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k,0, nums.length);
        return nums[k];
    }

    private void quickSort(int[] nums,int k,int left,int right) {
        int num = nums[left];
        int i = left;
        int j = right-1;
        while (i<j) {
            while (i<j && nums[j] >= num) {
                j--;
            }
            nums[i] = nums[j];
            while (i<j && nums[i] < num) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = num;
        if (i == k) return;
        if (i > left) {
            quickSort(nums, left, i);
        }
        if (i+1<right) {
            quickSort(nums, i + 1, right);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
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
        for (int i = 0; i <k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }
}
