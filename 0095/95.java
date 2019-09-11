/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        for(int i=l;i<=r;i++){
            List<TreeNode> ls = helper(l,i-1);
            List<TreeNode> rs = helper(i+1,r);
            for(TreeNode ln:ls){
                for(TreeNode rn: rs){
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    res.add(root);
                }
            }
            
        }
        
        return res;
    }
}