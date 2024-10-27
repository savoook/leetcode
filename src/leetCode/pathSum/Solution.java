package leetCode.pathSum;

import leetCode.elements.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        return (root.right == null && root.left == null && targetSum == 0 || hasPathSum(root.right, targetSum) || hasPathSum(root.left, targetSum));
    }
}
