Given an integer array nums, find the

with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Intuition

A subarray with a negative sum can never help in obtaining the maximum subarray sum in the future. If the current running sum becomes negative, adding future elements to it will only reduce the overall sum. Therefore, it is always better to discard the current subarray and start a new one from the next element.

This idea forms the basis of Kadane's Algorithm, where we maintain a running sum of the current subarray and continuously update the maximum sum encountered so far.
Approach

1-Initialize two variables:
currSum to store the sum of the current subarray.
max to store the maximum subarray sum found so far.
2-Traverse the array from left to right.
3-Add the current element to currSum.
4-Update max with the larger of max and currSum.
5-If currSum becomes negative, reset it to 0 since a negative running sum cannot contribute to a larger subarray sum in the future.
6-After traversing the entire array, return max, which represents the maximum sum among all possible contiguous subarrays.
Complexity

    Time complexity:

O(n)

    Space complexity:

O(1)

Code

class Solution {
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int currSum = 0;
       for(int i:nums){
        currSum += i;
        max = Math.max(max,currSum);
        if(currSum<0){
            currSum = 0;
        }
       } 
       return max;
    }
}
