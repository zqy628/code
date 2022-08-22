package com.code.day;

/**
 * @author zqy on 2022/8/22.
 */
//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 538 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.code.Demo;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class ConstructMaximumBinaryTree_654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int maxIndex = findMax(nums, 0, n - 1);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, 0, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, n - 1);
        return root;
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l>r) {
            return null;
        } else if (l==r) {
            TreeNode root = new TreeNode(nums[l]);
            return root;
        } else {
            int maxIndex = findMax(nums, l, r);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = construct(nums, l, maxIndex - 1);
            root.right = construct(nums, maxIndex + 1, r);
            return root;
        }
    }

    private int findMax(int[] nums, int l, int r) {
        int max = -1;
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

