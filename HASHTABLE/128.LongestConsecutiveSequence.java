// Intuition
// The intuition is to find the unique consecutive sequence of the elements by first finding the starting point of the subarray.

// Approach
// 1-Insert all the elements into a HashSet.
// This removes duplicate elements and allows checking whether an element exists in O(1) time on average.

// 2-Find the starting element of each consecutive sequence.
// For every element in the set, check whether its previous element (current - 1) exists.

// 3-If it exists, then the current element is not the start of a sequence, so skip it.
// If it does not exist, then the current element is the starting point of a new consecutive sequence.

// Example:
// Consider the set:

// {4, 3, 2, 1, 9, 10, 11, 15}
// For 4, 3 exists, so 4 is not the starting point.
// For 3, 2 exists, so skip it.
// For 2, 1 exists, so skip it.
// For 1, 0 does not exist, so 1 is the starting point of the sequence 1, 2, 3, 4.
// Similarly, 9 is the starting point of the sequence 9, 10, 11, and 15 is the starting point of a sequence of length 1.
// Calculate the length of the sequence.

// 4-Once a starting point is found, repeatedly check whether the next consecutive element (current + 1) exists in the set. Keep incrementing the current value and the sequence length until the next element is no longer present. Update the maximum length obtained among all such sequences.

// Time complexity:
// O(n)
// Space complexity:
// O(n)

Code
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max = 0;
        for(int i:set){
            int len = 1;
            if(!set.contains(i-1)){
                int val = i+1;
                while(set.contains(val)){
                    val++;
                    len++;
                }
            }
            max = Math.max(max,len);
        }
        return max;
    }
}