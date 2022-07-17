package com.code.day;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;

/**
 * @author zqy on 2022/6/23.
 */
public class FindBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        int r = -1;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                // System.out.println(poll.val);
                if (poll.left != null) {
                    nodes.offer(poll.left);
                }
                if (poll.right != null) {
                    nodes.offer(poll.right);
                }
                // 这一层最左边的节点
                if (i == 0) {
                    // System.out.println(poll.val);
                    r = poll.val;
                }
            }
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



