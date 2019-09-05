/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        int i=0;
        int n = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while(i<n){
            if(stack.isEmpty()||height[i]<height[stack.peek()]){
                stack.push(i++);
            }else{
                int t = stack.pop();
                if(stack.isEmpty()){
                    continue;
                }
                res += (Math.min(height[stack.peek()],height[i])-height[t])*(i-stack.peek()-1);
            }
        }
        return res;
    }
}