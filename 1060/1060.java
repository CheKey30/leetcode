/*
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

 

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 
*/

class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            int tmp = nums[mid] - nums[left] - (mid - left);
            if (tmp >= k) {
                right =mid;
            } else {
                left = mid;
                k -= tmp;
            }
        }
        
        if (nums[left] + k >= nums[right]) {
            return nums[left] + k + 1;
        }
        return nums[left] + k;
    }
}