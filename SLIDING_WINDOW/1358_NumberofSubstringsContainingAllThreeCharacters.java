// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

// Example 1:

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

// Intuition
// The intuition for this question is to iterat the given string by using two pointers, while keeping the track of the frequency of the elements.

// Approach
// 1-create a hashMap with key as character and the value as the frequency of the character.
// 2-create a variable to keep the track of all the subsequences found.
// 2-initially store the freqency of all the characters as 0.
// 3-iterate over the given string character-by-character.
// 4-as soon as the frequency of all the required characters becomes greater than 0, add s.length() - r to the answer.

// Why do we add s.length() - r?

// Suppose we are given the string:

// abcaaaaaa

// When the right pointer r reaches index 2, the current substring is:

// abc

// At this point, the substring contains all the required characters (a, b, and c), making it a valid substring.

// Now, if we keep the left pointer l fixed and continue extending the right pointer, every new substring will also remain valid because adding more characters cannot remove the characters that are already present.

// The possible valid substrings are:

// abc
// abca
// abcaa
// abcaaa
// abcaaaa
// abcaaaaa
// abcaaaaaa

// Instead of counting these substrings one by one, we can directly calculate their count.

// If the string length is n and the current right pointer is at index r, then the number of possible valid substrings is:

// n - r

// Hence, we add:

// count += s.length() - r;

// This optimization counts all valid substrings starting from the current left pointer in a single step, avoiding unnecessary iterations and making the sliding window solution efficient.

// Complexity
// Time complexity:
// O(n)
// Space complexity:
// O(n)

Code
class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);
        int ans = 0;
        int l = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            map.put(c,map.get(c)+1);
            while(map.get('a')>0&&map.get('b')>0&&map.get('c')>0){
                char g = s.charAt(l);
                map.put(g,map.get(g)-1);
                ans += s.length()-r;
                l++;
            }
        }
        return ans;
    }
}