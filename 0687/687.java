/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int local = 0;
        if(root.left!=null && root.right!=null && root.left.val==root.val && root.right.val==root.val){
            res = Math.max(res,left+right+2);
        }
        if(root.left !=null && root.left.val==root.val){
            res = Math.max(res,left+1);
            local = Math.max(local,left+1);
        }
        if(root.right!=null && root.right.val == root.val){
            res = Math.max(res,right+1);
            local = Math.max(local,right+1);
        }
        return local;
    }
}