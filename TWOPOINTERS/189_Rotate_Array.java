Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Intuition

Here the question is saying to rotate the given array by k places.
Approach

1-Calculate the actual rotation value k (since we don't the value of k
for example
arr[] = {1,2,3,4,5,6,7}, k=10
after 10 rotations the array will be 5,6,7,1,2,3,4
after 3 rotations the array will be 5,6,7,1,2,3,4
so, the catch is for k=10, when we are done with 7 rotations then we will be getting the same array)
2-for calculating the actual number of rotations we will be doing k = length of the array % k
3-reverse the whole array 7,6,5,4,3,2,1
4-reverse first k element of the array 5,6,7,4,3,2,1
5-reverse the remaining elements after k 5,6,7,1,2,3,4
Complexity

    Time complexity:

O(n)

    Space complexity:

O(1)

Code

class Solution {
    public void rotate(int[] nums, int k) {
       int len = nums.length;
       k = k%len;
       reverse(nums,0,len-1);
       reverse(nums,0,k-1);
       reverse(nums,k,len-1); 
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
