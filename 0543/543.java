/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
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
    public int diameterOfBinaryTree(TreeNode root) {
        return findLength(root)[0];
    }
    
    public int[] findLength(TreeNode root){
        if (root == null){
            return new int[]{0,-1,-1};
        }
        if(root.left==null && root.right==null){
            return new int[]{0,0,0};
        }
        int[] res1 = findLength(root.left);
        int[] res2 = findLength(root.right);
        int left = Math.max(res1[2],res1[1])+1;
        int right = Math.max(res2[1],res2[2])+1;
        int all = Math.max(Math.max(res1[0],res2[0]),left+right);
        return new int[]{all,left,right};
        
    }
}