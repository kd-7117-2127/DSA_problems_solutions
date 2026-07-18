Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

 

Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.

Intuition

Find the biggest and the smallest element from the given array and then calculate it's gcd.
Approach

Find the biggest and the smallest element from the given array and then calculate it's gcd(using the euclidean formula).
Complexity

    Time complexity:

O(n)

    Space complexity:

O(1)

Code

class Solution {
    public int findGCD(int[] nums) {
       int small = Integer.MAX_VALUE;
       int big = Integer.MIN_VALUE;
       for(int i:nums){
        small = Math.min(small,i);
        big = Math.max(big,i);
       } 
       return functGCD(small,big);
    }
    public int functGCD(int a,int b){
        if(b==0){
            return a;
        }
        return functGCD(b,a%b);
    }
}
