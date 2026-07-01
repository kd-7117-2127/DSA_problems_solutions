// Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

// A substring is a contiguous sequence of characters within a string.

 

// Example 1:

// Input: patterns = ["a","abc","bc","d"], word = "abc"
// Output: 3
// Explanation:
// - "a" appears as a substring in "abc".
// - "abc" appears as a substring in "abc".
// - "bc" appears as a substring in "abc".
// - "d" does not appear as a substring in "abc".
// 3 of the strings in patterns appear as a substring in word.

// Intuition
// As we know that strings which are created in are treated as an object.
// boolean contains(CharSequence sequence) Method
// This method returns true if string contains the given string.

// Approach
// Just apply the contains concept of java here.

// Complexity
// Time complexity:
// O(n)
// Space complexity:
// O(1)
Code
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String s:patterns){
            if(word.contains(s)){
                count++;
            }
        }
        return count;
    }
}