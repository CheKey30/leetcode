/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
*/

class Solution {
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0){
            return 0;
        }
        int n = ratings.length;
        int[] nums = new int[n];
        int count = 0;
        Arrays.fill(nums,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }
        for(int j= n-2;j>=0;j--){
            if(ratings[j]>ratings[j+1] && nums[j]<nums[j+1]+1){
                nums[j] = nums[j+1]+1;
            }
        }
        
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum;
        
    }
}