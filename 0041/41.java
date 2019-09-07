/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int l =0;
        int r = nums.length;
        while(l<r){
            if(nums[l]==l+1){
                l++;
            }else if(nums[l]<=l||nums[l]>r||nums[nums[l]-1]==nums[l]){
                nums[l] = nums[--r];
            }else{
                swap(nums,l,nums[l]-1);
            }
        }
        return l+1;
    }
    
    public void swap(int[] nums, int l, int r){
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }
}