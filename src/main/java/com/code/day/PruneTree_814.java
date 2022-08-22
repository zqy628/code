package com.code.day;

/**
 * @author zqy on 2022/7/21.
 */
public class PruneTree_814 {
    public class TreeNode {
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

    public TreeNode pruneTree(TreeNode root) {
        boolean root1 = dfs(root);
        return root1 ? root : null;

    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }

    // 参考解法
    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
