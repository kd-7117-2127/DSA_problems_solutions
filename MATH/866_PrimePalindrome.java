Given an integer n, return the smallest prime palindrome greater than or equal to n.

An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.

    For example, 2, 3, 5, 7, 11, and 13 are all primes.

An integer is a palindrome if it reads the same from left to right as it does from right to left.

    For example, 101 and 12321 are palindromes.

The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].

 

Example 1:

Input: n = 6
Output: 7

Example 2:

Input: n = 8
Output: 11

Example 3:

Input: n = 13
Output: 101

Intuition

A number is a valid answer only if it satisfies both conditions:

It is a prime number.
It is a palindrome.

Instead of generating palindromes separately, this solution simply starts from n and checks every integer one by one until it finds a number satisfying both properties.

An important optimization is that every even-length palindrome (except 11) is divisible by 11, so it cannot be prime. Therefore, once the search enters the range of 8-digit numbers (10,000,000 to 99,999,999), it skips directly to 100,000,000, avoiding millions of unnecessary checks.
Approach

1-Start checking numbers from n.
For each number:
2-Check if it is prime by testing divisibility from 2 to √n.
3-Check if it is a palindrome by comparing characters from both ends of its string representation.
4-If both conditions are true, return the current number.
5-Otherwise, increment the number and continue searching.
6-If the number enters the range 10,000,001 to 99,999,999, skip directly to 100,000,000 since no even-length palindrome in this range can be prime.
Complexity

    Time complexity:

Let k be the number of integers checked before finding the answer.

Prime check: O(√m), where m is the current number.
Palindrome check: O(d), where d is the number of digits (at most 9 for the given constraints).

Since d is very small compared to √m, the prime check dominates.

Overall:

O(k×m)​

    Space complexity:

    O(1)

Code

class Solution {
    public int primePalindrome(int n) {
       int num = n; 
       while(num>0){
        if(isPrime(n)&&isPalindrome(n)){
            return n;
        }
        n++;
        if(n>10000000&&n<100000000){
            n = 100000000;
        }
       } 
       return n;
    }
    boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    boolean isPalindrome(int n){
        String s = String.valueOf(n);
        int r = s.length()-1;
        int l = 0;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
