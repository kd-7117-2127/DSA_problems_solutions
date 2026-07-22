You are given a binary string s of length n, where:

    '1' represents an active section.
    '0' represents an inactive section.

You can perform at most one trade to maximize the number of active sections in s. In a trade, you:

    Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
    Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.

Return the maximum number of active sections in s after making the optimal trade.

Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not contribute to the final count.

Intuition

The trade can be performed at most once, so we only need to identify the best possible place where converting one valid block of 1s into 0s allows two neighboring 0 blocks to merge.

Instead of explicitly simulating the trade, observe that after removing a contiguous block of 1s surrounded by 0s, the two adjacent 0 blocks become a single larger 0 block. Converting this merged 0 block back to 1s increases the number of active sections.

First, count the number of 1s already present in the string since they are active by default. Then, store the lengths of every consecutive block of 0s. For every pair of adjacent 0 blocks, their combined length represents the size of the merged inactive block that can potentially be converted into 1s after removing the separating 1 block. The maximum such sum gives the largest possible gain, and adding it to the initial count of active sections gives the answer.
Approach

1-Count the total number of 1s in the string. This is the number of active sections before performing any trade.
2-Traverse the string and record the length of every consecutive block of 0s in a list.
3-Iterate through consecutive pairs of zero-block lengths.
*The sum of two adjacent zero-block lengths represents the merged 0 block obtained after removing the 1 block between them.
*Keep track of the maximum such sum.
4-The final answer is:
initial number of active sections (1s) + maximum merged zero-block length.
5-If no valid trade exists, the maximum merged length remains 0, so the original number of active sections is returned.
Complexity

    Time complexity:

O(n)

    Space complexity:

O(n)

Code

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
       int oneCount = 0;
       char[] ch = s.toCharArray();
       for(char c:ch){
        if(c=='1'){
            oneCount++;
        }
       } 
       int currZero = 0;
       List<Integer> list = new ArrayList<>();
       for(char c:ch){
        if(c=='0'){
            currZero++;
        }
        else{
            if(currZero!=0) list.add(currZero);
            currZero = 0;
        }
       }
       if(currZero!=0){
        list.add(currZero);
       }
       int maxConsecZero = 0;
       for(int i=0;i<list.size()-1;i++){
        maxConsecZero = Math.max(maxConsecZero,list.get(i)+list.get(i+1));
       }
       return maxConsecZero+oneCount;
    }
}
