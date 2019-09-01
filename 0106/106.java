/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length){
            return null;
        }
        int n = inorder.length;
        return bt(inorder, postorder, 0, n-1,0,n-1);
        
    }
    
    public TreeNode bt(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2){
        if(s1>e1 || s2>e2){
            return null;
        }
        TreeNode root = new TreeNode(postorder[e2]);
        int rootIndex = -1;
        for(int i=s1;i<=e1;i++){
            if(inorder[i]==root.val){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }
        int leftlength = rootIndex-s1;
        int rightlength = e1-rootIndex;
        root.left = bt(inorder,postorder,s1,s1+leftlength-1,s2,s2+leftlength-1);
        root.right = bt(inorder,postorder,rootIndex+1,e1,e2-rightlength,e2-1);
        return root;
    }
}