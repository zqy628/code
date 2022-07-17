package com.code.day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zqy on 2022/6/24.
 */
public class LargestValues_515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        List<Integer>  r = new ArrayList<>();
        if (root == null) {
            return r;
        }
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                if (poll.left != null) {
                    nodes.offer(poll.left);
                }
                if (poll.right != null) {
                    nodes.offer(poll.right);
                }
                max = Math.max(max, poll.val);
            }
            r.add(max);
        }
        return r;
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
