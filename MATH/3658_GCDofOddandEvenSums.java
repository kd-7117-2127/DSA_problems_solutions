You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

    sumOdd: the sum of the smallest n positive odd numbers.

    sumEven: the sum of the smallest n positive even numbers.

Return the GCD of sumOdd and sumEven.

 

Example 1:

Input: n = 4

Output: 4

Explanation:

    Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
    Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20

Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

Intuition

As per the question we need to calculate the sum of first n odd numbers and first n even nunbers and then we need to calculate the gcd of both.
-For the sum of first n even numbers n*(n+1)
-For the sum of first n odd numbers n*n

Now we need to calculate the gcd(nn, n(n+1))
which is n*[gcd(n, n+1)] // taking n common

--@as we know that two consecutive numbers are always coprime and hence their gcd will always we 1

So, the equation n*[gcd(n), n+1] becomes n*1
Approach

Just return n
Complexity

    Time complexity:

O(1)

    Space complexity:

O(1)

Code

class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
