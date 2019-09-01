/*
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:

The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
 

Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, you need to return the sum of all paths from the root towards the leaves.

Example 1:

Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
 

Example 2:

Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
*/

class Solution {
    int res = 0;
    public int pathSum(int[] nums) {
        if(nums == null){
            return 0;
        }
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i : nums){
            m.put(i/10,i%10);
        }
        
        helper(nums[0]/10,m,0);
        return res;
    }
    
    public void helper(int num,HashMap<Integer,Integer> m, int curr){
        int level = num/10;
        int pos = num%10;
        int left = (level+1)*10+2*pos-1;
        int right = (level+1)*10+2*pos;
        curr += m.get(num);
        if(! m.containsKey(left) && !m.containsKey(right)){
            res += curr;
            return;
        }
        if(m.containsKey(left)) helper(left,m,curr);
        if(m.containsKey(right)) helper(right,m,curr);
    }
}