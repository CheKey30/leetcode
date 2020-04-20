/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bfs(preorder,0,preorder.length-1);
    }
    
    public TreeNode bfs(int[] preorder, int l, int r){
        if(l>r){
            return null;
        }
        TreeNode node = new TreeNode(preorder[l]);
        boolean found = false;
        for(int i=l+1;i<=r;i++){
            if(preorder[i]>preorder[l]){
                node.right = bfs(preorder,i,r);
                node.left = bfs(preorder,l+1,i-1);
                found = true;
                break;
            }
        }
        if(!found){
            node.left = bfs(preorder,l+1,r);
        }
        return node;
    }
}