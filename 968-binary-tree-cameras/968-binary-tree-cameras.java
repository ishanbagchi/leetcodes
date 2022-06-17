/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cam = 0;
    
    public int helper(TreeNode node) {
        if (node == null) return 1;
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if (left == -1 || right == -1) {
            cam++;
            return 0;
        } else if (left == 0 || right == 0)
            return 1;
        else
            return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        if (helper(root) == -1)
            cam++;
        
        return cam;
    }
}