/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
*/

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
    TreeNode px = null;
    TreeNode py = null;
    int dx = 0;
    int dy = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        preorder(root,null,0,x,y);
        return (px!=py && dx==dy);
    }
    
    public void preorder(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root==null){
            return;
        }
        if(root.val==x){
            px = parent;
            dx = depth;
        }
        if(root.val == y){
            py = parent;
            dy = depth;
        }
        preorder(root.left,root,depth+1,x,y);
        preorder(root.right,root,depth+1,x,y);
    }
}