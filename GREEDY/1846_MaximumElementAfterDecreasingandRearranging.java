// You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:

// The value of the first element in arr must be 1.
// The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
// There are 2 types of operations that you can perform any number of times:

// Decrease the value of any element of arr to a smaller positive integer.
// Rearrange the elements of arr to be in any order.
// Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.

// Intuition
// The intuition is to find the maximum element from the given array after performing all the operations described in the question.

// Approach
// 1-sort in an non-decreasing order.
// 2-interate the sorted array from the 1st index and check if the condition follows which the difference between the adjacent elements should be less than or equal to 1 for which we are considering the minimum value among the next value and value which we get by increementing the current value.
// 3-return the maximum value which we got so far.

// Complexity
// Time complexity:
// O(n)
// Space complexity:
// O(1)

Code
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            arr[i+1] = Math.min(arr[i]+1,arr[i+1]);
            max = Math.max(max,arr[i+1]);
        }
        return max;
    }
}