/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        int n = preorder.length;
        return bt(preorder,inorder,0,n-1,0,n-1);
    }
    
    public TreeNode bt(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2){
        if(s1>e1||s2>e2){
            return null;
        }
        int index = -1;
        TreeNode root = new TreeNode(preorder[s2]);
        for(int i=s1;i<=e1;i++){
            if(root.val == inorder[i]){
                index = i;
                break;
            }
        }
        if(index == -1){
            return null;
        }
        int leftsize = index-s1;
        int rightsize = e1-index;
        root.left = bt(preorder,inorder,s1,index-1,s2+1,s2+leftsize);
        root.right = bt(preorder,inorder,index+1,index+rightsize,s2+1+leftsize,s2+leftsize+rightsize);
        return root;
    }
}