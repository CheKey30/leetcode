/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0||nums==null){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(i==0||nums[i]!=nums[i-1]){
                res.addAll(twoSum(nums,i+1,nums.length-1,-nums[i]));
            }
        }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int start,int end, int target){
        int l = start;
        int r = end;
        List<List<Integer>> tmp = new ArrayList<>();
        while(l<r){
            if(nums[l]+nums[r]<target){
                l++;
            }else if(nums[l]+nums[r]>target){
                r--;
            }else{
                if(l==start||nums[l]!=nums[l-1]){
                    tmp.add(Arrays.asList(-target,nums[l],nums[r]));
                }
                l++;
                r--;
            }
        }
        return tmp;
    }
}