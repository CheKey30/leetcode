/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;
        int l1 = 0;
        int l2 = 0;
        List<Integer> arr = new ArrayList<Integer>();
        while(l1<nums1.length && l2<nums2.length){
            if(nums1[l1]<nums2[l2]){
                arr.add(nums1[l1]);
                l1++;
            }else{
                arr.add(nums2[l2]);
                l2++;
            }
        }
        if(l1<nums1.length){
            for(int i=l1;i<nums1.length;i++){
                arr.add(nums1[i]);
            }
        }
        if(l2<nums2.length){
            for(int i=l2;i<nums2.length;i++){
                arr.add(nums2[i]);
            }
        }
        
       
        if(n%2!=0){
            return (float) arr.get(n/2);
        }else{
            return ((float)arr.get((n-1)/2)+(float)arr.get(n/2))/2;
        }
    }
}



// method2
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (find(nums1,0,nums2,0,left)+find(nums1,0,nums2,0,right))/2.0;
    }
    
    public int find(int[] nums1, int i, int[] nums2, int j, int k){
        if(i>=nums1.length){
            return nums2[j+k-1];
        }
        if(j>=nums2.length){
            return nums1[i+k-1];
        }
        if(k==1){
            return Math.min(nums1[i],nums2[j]);
        }
        int val1 = (i+k/2-1>=nums1.length) ? Integer.MAX_VALUE: nums1[i+k/2-1];
        int val2 = (j+k/2-1>=nums2.length) ? Integer.MAX_VALUE: nums2[j+k/2-1];
        if(val1>val2){
            return find(nums1,i,nums2,j+k/2,k-k/2);
        }else{
            return find(nums1,i+k/2,nums2,j,k-k/2);
        }
    }
}