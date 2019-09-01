/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
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
    TreeNode prve = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        if(root ==null){
            return;
        }
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        if(prve != null && prve.val>node.val){
            if(first == null){
                first = prve;
            }
            second = node;
        }
        prve = node;
        inOrder(node.right);
    }
}
