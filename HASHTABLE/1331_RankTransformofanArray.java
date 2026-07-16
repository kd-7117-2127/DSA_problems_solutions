Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

    Rank is an integer starting from 1.
    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    Rank should be as small as possible.

 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.

Intuition

The intuition for this question is to sort the array and keep the record of the positions of the sorted array using the hashmap and create a new array and fill it with the positions extracted from the hash map
Approach

1-create a copy of the given array.
2-sort the copied array.
3-create a hashmap which will be used for storing the actual positions using the sorted array.
4-create an answer array
5-iterate over the given arr and fill the ans array by extracting the positions from the hashmap.
Complexity

    Time complexity:

O(n)

    Space complexity:

O(n)

Code

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] narr = new int[n];
        for(int i=0;i<n;i++){
            narr[i] = arr[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(narr);
        int ind = 1;
        for(int i:narr){
            if(!map.containsKey(i)){
                map.put(i,ind);
                ind++;
            }
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
