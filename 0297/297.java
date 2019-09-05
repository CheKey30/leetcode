/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
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
public class Codec {
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        String str = "";
        str+=root.val+"!";
        str+=serialize(root.left);
        str+=serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<String>();
        String[] vals = data.split("!");
        for(String x : vals){
            queue.add(x);
        }
        return helper(queue);
    }
    
    public TreeNode helper(LinkedList<String> queue){
        String val = queue.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = helper(queue);
        head.right = helper(queue);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));