/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int zp = -1;
        int np = 0;
        while(zp<nums.length && np<nums.length){
            if (nums[np] == 0){
                if(zp==-1){
                    zp = np;
                }
                np++;
            }else{
                if(zp==-1){
                    np++;
                }else{
                    nums[zp] = nums[np];
                    nums[np] = 0;
                    np++;
                    zp++;
                }
                
            }
        }
    }
}