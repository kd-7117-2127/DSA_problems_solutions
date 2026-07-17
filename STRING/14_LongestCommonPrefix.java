Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Intuition

Since the longest common prefix must be a prefix of every string in the array, we can use the first string as a reference. We compare each character of the first string with the character at the same position in every other string. As soon as we encounter a mismatch or reach the end of any string, we know that the common prefix ends there.
Approach

1-Store the first string of the array as the reference string.
2-Iterate through each character of the reference string using an index i.
3-For every position i, compare the character first.charAt(i) with the character at the same index in every other string in the array.

4-If any string:

has length equal to i (meaning it ends before this position), or
has a different character at index i,

return the substring of the reference string from index 0 to i, as that is the longest common prefix found so far.

5-If the entire reference string is successfully traversed without any mismatch, return the reference string itself, since it is the common prefix of all strings.
Complexity

    Time complexity:

O(n*m)

    Space complexity:

O(1)

Code

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for(int i=0;i<first.length();i++){
            char c = first.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||c!=strs[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}
