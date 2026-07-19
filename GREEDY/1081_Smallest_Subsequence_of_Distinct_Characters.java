Intuition

Here the question say's to return the lexicographically smallest subsequence of the given string s that should be containing all destinct characters of string s.

As the questions says that the subsequence of the string should be lexicographically smallest (means it should be in an order a,b,c,d....), whenever there is question asking for the increasing or decreasing order of any array or string we will be making use of the monotonic stack, since monotonic stack could be used for maintaining an increasing order of elements as well as decreasing order of elements.
Approach

1-create a hashmap that would be required to store the last occurences of each distinct character.
2-create a set that will required to check the duplicacy of characters.
3-create a stack that will be required for maintaining the monotonic order of the characters.
4-WORKING
-suppose the given string is bcabc
-after the first two iterations the stack would be containing b,c
-on its third iteration when index i points to 2 and the character is a which is smaller than peek() of the stack (c) we will remove it
-but before removing it we need to check whether is there another occurence of c available later (this is done using the hashmap which was meant for storing the last occurence of each distinct character from the string)
Complexity

    Time complexity:

O(n)

    Space complexity:

O(n)

Code

class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            map.put(s.charAt(i),i);
        }
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                continue;
            }
            while(!stack.isEmpty()&&c<stack.peek()&&map.get(stack.peek())>i){
                set.remove(stack.peek());
                stack.pop();
            }
            set.add(c);
            stack.push(c);
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
