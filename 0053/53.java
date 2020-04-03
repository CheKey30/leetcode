/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int left =0;
        int right = 1;
        int sum = nums[0];
        int max = nums[0];
        if(nums.length ==1){
            return max;
        }
        while(left<nums.length && right<nums.length){
            if((sum+nums[right])<nums[right]){
                left = right;
                sum = nums[right];
                right++;
                if(sum>max){
                    max = sum;
                }
            }else{
                sum+=nums[right];
                right++;
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }
}