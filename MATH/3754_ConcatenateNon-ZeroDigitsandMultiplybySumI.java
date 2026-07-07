You are given an integer n.

Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.

Let sum be the sum of digits in x.

Return an integer representing the value of x * sum.

 

Example 1:

Input: n = 10203004

Output: 12340

Intuition

The problem requires two operations on the given number:

    Construct a new number by removing all the 0 digits while preserving the order of the remaining digits.
    Calculate the sum of all the digits of the original number.

Once both values are obtained, return the product of the newly formed number and the digit sum.
Approach

    Initialize three variables:
        place to keep track of the current decimal position in the new number.
        num to store the number formed after removing all zeros.
        sum to store the sum of all digits.
    Traverse the number digit by digit from right to left using the modulo (%) and division (/) operations.
    For each extracted digit:
        Add it to sum.
        If the digit is non-zero, place it at the correct position in num using the place multiplier and then update place by multiplying it by 10.
    Continue until all digits have been processed.
    Return the product num * sum.

Complexity

    Time complexity:
    O(d), where d is the number of digits in n, since each digit is processed exactly once.

    Space complexity:
    O(1), as only a constant amount of extra space is used.

Code

class Solution {
    public long sumAndMultiply(int n) {
        long place = 1;
        long num = 0;
        long sum = 0;

        while (n > 0) {
            int val = n % 10;

            if (val != 0) {
                num += place * val;
                place *= 10;
            }

            sum += val;
            n /= 10;
        }

        return num * sum;
    }
}
