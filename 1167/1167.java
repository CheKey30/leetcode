/*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

 

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30
*/

class Solution {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            queue.add(sticks[i]);
        }
        for(int j=0;j<n-1;j++){
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a+b);
            cost += a+b;
        }
        return cost;
    }
}