Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.

An integer m is a divisor of n if there exists an integer k such that n = k * m.

 

Example 1:

Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.

Intuition

Just count the occurence from the given range 2 to n-1,
Since 1 and n itself are the two multiples of n.
Approach

Just count the occurence from the given range 2 to n-1,
Since 1 and n itself are the two multiples of n.
Complexity

    Time complexity:

O(n)

    Space complexity:

O(1)

Code

class Solution {
    public boolean isThree(int n) {
       if(n<=2){
        return false;
       }
       int count = 0;
       for(int i=2;i<n;i++){
        if(n%i==0){
            count++;
        }
       } 
       return count==1;
    }
}
