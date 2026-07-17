Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Intuition

This problem is closely related to the Two Sum problem.

In Two Sum, we look for a previously seen value such that:

[
{currentValue} - {target}
]

exists in a hash map.

Similarly, in this problem, instead of storing individual values, we store prefix sums. Let prefixSum be the sum of all elements from the beginning of the array up to the current index.

Suppose the current prefix sum is sum. If there exists a previous prefix sum equal to sum - k, then the elements between those two prefix sums form a subarray whose sum is exactly k.

Therefore, the idea is to maintain a HashMap that stores each prefix sum along with the number of times it has occurred. While traversing the array, we continuously compute the current prefix sum and check whether sum - k has already been seen. If it has, its frequency represents the number of subarrays ending at the current index whose sum is k.
Approach

    Create a HashMap to store prefix sums and their frequencies.

    Initialize the map with {0 : 1} to account for subarrays that start from index 0.

    Maintain a variable sum to store the current prefix sum.

    Traverse the array:
        Add the current element to sum.
        Check whether sum - k exists in the map.
        If it exists, add its frequency to the answer since each occurrence represents a valid subarray ending at the current index.
        Insert the current prefix sum into the map or increment its frequency if it already exists.

    Return the final count of valid subarrays.

Complexity

    Time Complexity: O(n)

    We traverse the array only once, and each HashMap operation takes O(1) on average.

    Space Complexity: O(n)

    In the worst case, all prefix sums are distinct and stored in the hash map.

Code

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
