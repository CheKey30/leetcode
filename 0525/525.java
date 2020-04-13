/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int maxVal = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                sum-=1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                maxVal = Math.max(maxVal,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxVal;
    }
}